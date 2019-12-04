package Mario;

import Mario.Entity.Player;
import Mario.Graphics.Sprite;
import Mario.Graphics.SpriteSheet;
import Mario.Input.KeyInput;
import Mario.Tile.Wall;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 270;
    public static final int HEIGHT = WIDTH/14 * 10;
    public static final int SCALE = 4;

    private boolean running = false;
    private  Thread thread = new Thread(this);

    protected synchronized void start() {
        if(running) return;
        running = true;
        thread.start();
    }

    private synchronized void stop(){
        if(!running) return;
        running = false;
        try {
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    // Runnable Method
    @Override
    public void run() {
        init();
        requestFocus();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0.0;
        double ns = 1000000000.0/60.0;
        int frames = 0;
        int ticks = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime )/ ns;
            lastTime = now;

            while(delta >= 1){
                tick();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(frames + " frames per second " + ticks + " ticks per second");
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }


    // Render
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
          createBufferStrategy(3);
          return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());
        handler.render(g);
        g.dispose();
        bs.show();
    }

    // Tick/Update  Method
    public void tick(){
        handler.tick();
    }

    public static Handler handler;
    public static SpriteSheet sheet;
    
    // Creating the Sprites
    public static Sprite grass;
    public static Sprite player;

    public Game(){
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMaximumSize(size);

    }

    // Initializing objects
    private void init(){
    handler = new Handler();
    
    sheet = new SpriteSheet("/spritesheet.png");
    
    addKeyListener( new KeyInput());
    
    grass = new Sprite(sheet, 2, 1);
    player = new Sprite(sheet, 1, 1 );
    
    handler.addEntity(new Player(200, 200, 64, 64, true, Id.player, handler));
//    handler.addTile(new Wall(400, 400, 64, 64, true, Id.wall, handler));
    }




}



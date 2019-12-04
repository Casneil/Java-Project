package Mario.Entity;
import Mario.Game;
import Mario.Handler;
import Mario.Id;
import Mario.Tile.Tile;

import java.awt.*;

// Extending the abstract Entity Class
public class Player extends Entity {

    public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        // Calling the super method
        super(x, y, width, height, solid, id, handler);
        // Setting Velx
//        setVelx(5);

    }

    @Override
    public void render(Graphics g) {
    	g.drawImage(Game.player.getBufferedImage(), x, y, width, height, null);
//        g.setColor(Color.WHITE);
//        g.fillRect(x, y, width, height);

    }

    @Override
    public void tick() {
    // Moving the player
        x += velx;
        y += vely;

        // Collision Check for play area
        if(x <= 0) x = 0;
//        if(y <= 0) y = 0;
        if(x + width >= 1080) x = 1080 - width;
        if(y + height >= 771) y = 771 - height;

        // Implement collision boxes
        for(Tile t: handler.tile ){
                if(!t.solid) break;
                if(t.getId() == Id.wall){
                    if(getBoundsTop().intersects(t.getBounds())){
                        setVely(0);
                        if(jumping){
                            jumping = false;
                            gravity = 0.0;
                            falling = true;
                        }
//                        y = t.getY() + t.height;
                    }
                    if(getBoundsBottom().intersects(t.getBounds())){
                        setVely(0);
                        if(falling) {
                            falling = false;
                        }
//                        y = t.getY() - t.height ;
                    }else{
                        if(!falling && !jumping){
                            gravity = 0.0;
                            falling = true;
                        }
                    }
                    if(getBoundsLeft().intersects(t.getBounds())){
                        setVelx(0);
                        x = t.getX() + t.width;
                    }
                    if(getBoundsRight().intersects(t.getBounds())){
                        setVelx(0);
                        x = t.getX() - t.height;
                    }
                }
        }
        if(jumping){
            gravity -= 0.1;
            setVely((int)-gravity);
            if(gravity <= 0.0){
                jumping = false;
                falling = true;
            }
        }
            if(falling){
                gravity += 0.1;
                setVely((int) gravity);
            }
    }
}

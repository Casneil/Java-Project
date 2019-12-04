package Mario.Tile;
import Mario.Game;
import Mario.Handler;
import Mario.Id;
import java.awt.*;

public class Wall extends Tile {
    public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {

        // Calling super Class
        super(x, y, width, height, solid, id, handler);
    }

    @Override
    public void render(Graphics g) {
    	g.drawImage(Game.grass.getBufferedImage(), x, y, width, height, null);
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, width, height);

    }

    @Override
    public void tick() {

    }
}

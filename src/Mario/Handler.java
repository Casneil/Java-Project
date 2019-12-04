package Mario;
import Mario.Entity.Entity;
import Mario.Tile.Tile;
import Mario.Tile.Wall;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    public LinkedList<Entity> entity = new LinkedList<Entity>();
    public LinkedList<Tile> tile = new LinkedList<Tile>();

    // Handler constructor
    public Handler(){
        createLevel();
    }

    public void render(Graphics g){
    for(Entity en : entity){
        en.render(g);
    }

    for(Tile tiles : tile){
        tiles.render(g);
    }
    }

    public void tick(){
        for(Entity en : entity){
            en.tick();
        }

        for(Tile tiles : tile){
            tiles.tick();
        }
    }

    // Entities
    public void addEntity(Entity en){
        entity.add(en);
    }

    public void removeEntity(Entity en){
        entity.remove(en);
    }

    // Tile Entities
    public void addTile(Tile tiles){
        tile.add(tiles);
    }

    public void removeTile(Tile tiles){
        tile.remove(tiles);
    }

    // Level
    public void createLevel(){
        for(int i = 0;  i <Game.WIDTH * Game.SCALE / 64
                + 1 ; i ++){
            addTile(new Wall(i * 64, Game.HEIGHT * Game.SCALE - 64
                    , 64, 64, true, Id.wall, this));

            if(i != 0 && i != 1 &&  i != 15 &&i != 16 && i != 17){
                addTile(new Wall(i * 64, 300
                        , 64, 64, true, Id.wall, this));
            }
        };
    }


}

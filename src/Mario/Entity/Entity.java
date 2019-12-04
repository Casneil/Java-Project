package Mario.Entity;
import Mario.Handler;
import Mario.Id;
import java.awt.*;

public abstract  class Entity {
    public int x, y;
    public int width, height;
    public boolean solid;
    public  boolean jumping = false;
    public boolean falling = true;
    public double gravity = 0.0;

    public int velx, vely;
    public Handler handler;

    // From ENUM File
    public Id id;


    public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this. solid = solid;
        this.id = id;
        this.handler = handler;

    }

    public abstract void render(Graphics g);



    public abstract void tick();


    public void die(){
    handler.removeEntity(this);
    }



    //Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public int getVelx() {
        return velx;
    }

    public void setVelx(int velx) {
        this.velx = velx;
    }

    public int getVely() {
        return vely;
    }

    public void setVely(int vely) {
        this.vely = vely;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    // Rectangle method for entity collision detecsion
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), width, height);
    }

    public Rectangle getBoundsTop(){
        return new Rectangle(getX() + 10,  getY(),  width - 20,  5);
    }

    public Rectangle getBoundsBottom(){
        return new Rectangle(getX() + 10,  getY() + height- 5,  width - 20,  5);
    }

    public Rectangle getBoundsLeft(){
        return new Rectangle(getX() ,  getY() + 10,  5,  height - 20);
    }

    public Rectangle getBoundsRight(){
        return new Rectangle(getX() + width - 5,  getY() + 10,  5,  height - 20);
    }
}

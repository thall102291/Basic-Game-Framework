import java.awt.*;

/**
 * Entity.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * A superclass for any in-game objects. Usefull for using the factory design pattern
 * for managing game entities.
 */

public abstract class Entity {

    protected int x, y, width, height;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**Update Entity Logic*/
    abstract void update(double delta);
    
    /**Render Entity*/
    abstract void draw(Graphics g);
}

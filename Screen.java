import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Screen.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * Interface to create screens to encapsulate each of the different screens
 * of the game. i.e. menu, game, credits, etc...
 */
public interface Screen {

	/**Anything that needs to be updated goes in this method*/
    void tick(double delta);

    /**Draws content of the screen*/
    void draw(Graphics g);
    
    /**Method to call any methods upon the screen being destroyed*/
    void dispose();
    
    /**Passes the mouseevent data to be handled in the screen, return true if event has been properly handled.*/
    boolean handleEvent(MouseEvent e);
}

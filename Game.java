import java.awt.*;

/**
 * Game.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * Encapsulates the actual game from the window.
 */
public class Game {

    private ScreenManager screenman;
    private InputHandler inhand;
    public static int WIDTH = 1280;
    public static int HEIGHT = 800;

    public Game(){
        inhand = new InputHandler();
        screenman = new ScreenManager();
        inhand.addListener(screenman);

    }
    
    /** Game Logic handled Here*/
    public void tick(double delta){
        screenman.tick(delta);
    }

    /**Clears out the previous frame and then redraws the next frame*/
    public void draw(Graphics g){
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        screenman.draw(g);
    }

    public InputHandler getInputHandler(){ return inhand; }


}

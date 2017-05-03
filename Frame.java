import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

/**
 * Frame.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * The Game Window.
 */
public class Frame extends JFrame{

    public static final int WIDTH = 1280, HEIGHT = 800;
    private BufferedImage img;

    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Term Con");
        setResizable(false);
        setLocationRelativeTo(null);

        MyPanel p = new MyPanel();
        setContentPane(p);
        pack();

        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB); //image to be drawn to screen

        p.start();

        setVisible(true);

    }


    /**
     * MyPanel.java
     * @date 5/1/17
     * @author Timothy
     * @version 1.0
     * The container the game will be drawn on/ recieve user mouse input.
     */
    public class MyPanel extends JPanel implements MouseInputListener, MouseMotionListener{

        private GameThread thread;
        private Game game;
        private double fps;


        public MyPanel(){
            Dimension d = new Dimension(Game.WIDTH,Game.HEIGHT);
            setMaximumSize(d);
            setPreferredSize(d);
            setMinimumSize(d);
            setBackground(Color.WHITE);
            setFocusable(true);
            setDoubleBuffered(true);
            addMouseListener(this);
            addMouseMotionListener(this);

            game = new Game();
            thread = new GameThread(this);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            game.tick(thread.DELTA / 1000000.0);
            game.draw(img.getGraphics());
//            g.setColor(MyColors.BACKGROUND);
            g.drawRect(0, 0, Game.WIDTH, Game.HEIGHT);
            render(g);
        }

        private void render(Graphics g){
            g.drawImage(img, 0,0, this);
            drawStats(g);
            g.dispose();
        }

        /** draws fps counter in lower left corner*/
        private void drawStats(Graphics g){
            g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            g.setColor(Color.WHITE);
            g.drawString("FPS: " + fps, 10, Dimensions.HEIGHT - 5);
        }

        public void start(){
            thread.setRunning(true);
            thread.start();
        }

        public void stop(){
            boolean retry = true;

            while(retry){
                try{
                    thread.setRunning(false);
                    thread.join();
                } catch(Exception e){
                    e.printStackTrace();
                }
                retry = false;
            }
        }

        public void draw() {

            repaint();
        }

        public void tick(){

        }

        public void updateFPS(double fps){
            this.fps = fps;
        }

        public void mouseClicked(MouseEvent e)  { game.getInputHandler().mouseClicked(e); }
        public void mousePressed(MouseEvent e)  { game.getInputHandler().mousePressed(e); }
        public void mouseReleased(MouseEvent e) { game.getInputHandler().mouseReleased(e); }
        public void mouseEntered(MouseEvent e)  { game.getInputHandler().mouseEntered(e); }
        public void mouseExited(MouseEvent e)   { game.getInputHandler().mouseExited(e); }
        public void mouseDragged(MouseEvent e)  { game.getInputHandler().mouseDragged(e); }
        public void mouseMoved(MouseEvent e)    { game.getInputHandler().mouseMoved(e); }
    }

}

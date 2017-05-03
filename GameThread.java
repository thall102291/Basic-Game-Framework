/**
 * GameThread.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * The thread that runs the game loop. Refreshes the screen and logic a specified
 * amount of times per second (FPS).
 */
public class GameThread extends Thread {

    public static final int MAX_FPS = 60;
    public static double DELTA;
    private boolean running = false;
    private double averageFPS;
    private Frame.MyPanel p;

    public GameThread(Frame.MyPanel gp){
        setName("Game Thread");
        this.p = gp;
    }

    public void run(){
        long startTime;
        long timemillis;
        long waittime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;

        while(running){
            startTime = System.nanoTime();

            try{
                p.tick();
                p.repaint();
            }catch(Exception e){
                e.printStackTrace();
            }

            timemillis = (System.nanoTime() - startTime) / 1000000;
            waittime = targetTime - timemillis;

            try{
                if(waittime > 0) sleep(waittime);
            }catch (Exception e) {
                e.printStackTrace();
            }
            DELTA = System.nanoTime() - startTime;
            totalTime += DELTA;
            frameCount++;

            if(frameCount == MAX_FPS){
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                updateFPS();
            }
        }
    }

    public void setRunning(boolean running){ this.running = running; }

    /** Passes the current frame rate to the {@link Frame.MyPanel} to be rendered*/
    private void updateFPS(){ p.updateFPS(averageFPS); }
}

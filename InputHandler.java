import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * InputHandler.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * A bridge to connect the mouseevents of the MyPanel with the game itself.
 */
public class InputHandler {

    private ArrayList<EventListener> listeners;

    public InputHandler(){
        listeners = new ArrayList<>();
    }

    public  void notifyListeners(MouseEvent e){
      for(EventListener el : listeners){
          el.handleEvent(e);
      }
    }

    public void addListener(EventListener el){
        listeners.add(el);
    }

    public void mouseClicked(MouseEvent e) {
        notifyListeners(e);
    }

    public void mousePressed(MouseEvent e) {
       notifyListeners(e);

    }

    public void mouseReleased(MouseEvent e) {
        notifyListeners(e);

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        notifyListeners(e);
    }

    public void mouseMoved(MouseEvent e) {

    }


    public interface EventListener{
        boolean handleEvent(MouseEvent e);
    }
}

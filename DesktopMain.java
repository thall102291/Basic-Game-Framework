import javax.swing.*;

/**
 * DesktopMain.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 */

public class DesktopMain {
    public static final String version = "3.0.0";

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame f = new Frame();
                f.setTitle("Term Con | vs " + version);
            }
        });
    }
}

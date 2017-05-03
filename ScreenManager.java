package com.sc.snake;


import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * ScreenManager.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * Manages screen creation, disposal and transitions. Has the potential to use a 
 * stack to manage the screens (like a FSM) if game frequently goes back and forth
 * through screens.
 */
public class ScreenManager implements InputHandler.EventListener {

    private Screen active; //screen currently visible

    public ScreenManager(){
        setScreen(new GameScreen());
    }

    public void draw(Graphics g){
        active.draw(g);
    }

    public void tick(double delta){
        active.tick(delta);
    }

    public void setScreen(Screen s){
        if(active != null){
            active.dispose();
        }
        active = s;
    }

    public Screen getActiveScreen(){ return active; }

    @Override
    public boolean handleEvent(MouseEvent e) {
        return active.handleEvent(e);
    }
}

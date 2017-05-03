package com.sc.snake;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * /**
 * GameScreen.java
 * @date 5/1/17
 * @author Timothy
 * @version 1.0
 * Example Screen that will contain the actual game.
 */
public class GameScreen implements Screen {

    public GameScreen(){
        //initialize all in game objects here
    }
   
    @Override
    public void tick(double delta) {}

    @Override
    public void draw(Graphics g) {}

    @Override
    public void dispose() {}

    @Override
    public boolean handleEvent(MouseEvent e) {
        return false;
    }
}
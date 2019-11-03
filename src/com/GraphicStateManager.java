package com;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GraphicStateManager {

    public static final int PLAYSTATE = 1;

    private int state;
    private State[] states;

    public GraphicStateManager(int state ) {
        states = new State[1];
        states[0] = new Playstate(this);
    }

    public void update () {
        states[state].update();
    }

    public void render(Graphics2D g	) {
        states[state].render(g);
    }

    public  void keyPressed(KeyEvent e, int k) {
        states[state].keyPressed(e, k);
    }


    public  void keyReleased(KeyEvent e, int k){
        states[state].keyReleased(e, k);
    }

    public  void mousePressed(MouseEvent e){
        states[state].mousePressed(e);
    }

    public  void mouseReleased(MouseEvent e) {
        states[state].mouseReleased(e);
    }


}

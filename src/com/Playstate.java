package com;

import com.graphic_object.World;
import com.logic.Calculator;
import com.window_panel.MenuPanel;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Playstate extends State {


  World world;



  public Playstate(GraphicStateManager gsm) {
    super(gsm);
    world = new World();


  }

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics2D g) {
    g.clearRect(0, 0, GraphicPanel.width, GraphicPanel.height);
    world.render(g);

    //TO DO : Index x and y
    Font font = new Font("TimesRoman", Font.ITALIC, 12);
    g.setFont(font);
    for (int k = 0; k < World.BLOCKS; k++) {
      g.drawString(String.format("%d",k),
              World.DIST_TO_00-MainWindow.BLOCKSIZE,
              World.DIST_TO_00+MainWindow.BLOCKSIZE+k*MainWindow.BLOCKSIZE-4
      );

      g.drawString(String.format("%d",k),
              k<10?World.DIST_TO_00+4+k*MainWindow.BLOCKSIZE:World.DIST_TO_00+k*MainWindow.BLOCKSIZE+1,
              World.DIST_TO_00-2

      );
    }
    //====================
    Calculator.draw(g);


  }

  @Override
  public void keyPressed(KeyEvent e, int k) {
    switch(k){
      case KeyEvent.VK_UP:
        System.out.println("up");
        break;
      case KeyEvent.VK_DOWN:
        System.out.println("down");
        break;
      case KeyEvent.VK_LEFT:
        System.out.println("left");
        break;
      case KeyEvent.VK_RIGHT:
        System.out.println("right");
        break;

    }
  }

  @Override
  public void keyReleased(KeyEvent e, int k) {

  }

  @Override
  public void mousePressed(MouseEvent e) {

    int x = e.getX();
    int y = e.getY();

    //String s  = String.format("x=%d, y=%d", x, y);
    //System.out.println(s);

    if(     MenuPanel.worldEditMenu.isWorldEdit()
            && x>World.DIST_TO_00 && x<World.DIST_TO_00+(World.BLOCKS*MainWindow.BLOCKSIZE)
            && y>World.DIST_TO_00 && y<World.DIST_TO_00+(World.BLOCKS*MainWindow.BLOCKSIZE)){

      world.worldMouseKeyPresed(x, y);

    }





  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

}

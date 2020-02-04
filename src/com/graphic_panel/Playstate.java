package com.graphic_panel;

import com.MainWindow;
import com.logic_package.Calculator;
import com.window_panel.MenuPanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Playstate {


  private World world;
  private Calculator calculator;


  public Playstate() {
    world = new World();
    calculator = new Calculator();


    JButton runBtn = MainWindow.menuPanel.getRunButton();
    runBtn.addActionListener(e -> {
      try {
        calculator.calculate(world);
      } catch (Exception ex) {
        MenuPanel.println(ex.getMessage());
      }
    });

    JButton clearBtn = MainWindow.menuPanel.getClearButton();
    clearBtn.addActionListener(e -> {
      try {
        calculator.clear(world);
      } catch (Exception ex) {
        MenuPanel.println(ex.getMessage());
      }
    });
  }

  public void update() {

  }

  public void render(Graphics2D g) {
    g.clearRect(0, 0, GraphicPanel.width, GraphicPanel.height);
    world.render(g);

    //TO DO : Index x and y
    Font font = new Font("TimesRoman", Font.ITALIC, 12);
    g.setFont(font);
    for (int k = 0; k < World.BLOCKS; k++) {
      g.drawString(String.format("%d", k),
              World.DIST_TO_00 - MainWindow.BLOCKSIZE,
              World.DIST_TO_00 + MainWindow.BLOCKSIZE + k * MainWindow.BLOCKSIZE - 4
      );

      g.drawString(String.format("%d", k),
              k < 10 ? World.DIST_TO_00 + 4 + k * MainWindow.BLOCKSIZE : World.DIST_TO_00 + k * MainWindow.BLOCKSIZE + 1,
              World.DIST_TO_00 - 2

      );
    }
    //====================
    calculator.draw(g);

  }

  public void keyPressed(KeyEvent e, int k) {
    switch (k) {
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

  public void keyReleased(KeyEvent e, int k) {

  }

  public void mousePressed(MouseEvent e) {

    int x = e.getX();
    int y = e.getY();


    //String s  = String.format("x=%d, y=%d", x, y);
    //System.out.println(s);

    if (insideWorldCoordinatesAndWorldEditMode(x, y)) {
      world.worldMouseKeyPresed(x, y);
    }


  }

  public void mouseReleased(MouseEvent e) {

  }

  public void mouseMoved(MouseEvent e) {

  }

  public void mouseDragged(MouseEvent e) {

    int x = e.getX();
    int y = e.getY();

    if (insideWorldCoordinatesAndWorldEditMode(x, y)) {
      world.worldMouseDragged(x, y,SwingUtilities.isLeftMouseButton(e), SwingUtilities.isRightMouseButton(e));
    }


  }

  private boolean insideWorldCoordinatesAndWorldEditMode(final int x, final int y) {
    return (MenuPanel.worldEditMenu.isWorldEdit()
            && x > World.DIST_TO_00 && x < World.DIST_TO_00 + (World.BLOCKS * MainWindow.BLOCKSIZE)
            && y > World.DIST_TO_00 && y < World.DIST_TO_00 + (World.BLOCKS * MainWindow.BLOCKSIZE)) ;
  }
}

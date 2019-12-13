package com.graphic_panel;

import java.awt.*;

public class Circle {

  private int indexX;
  private int indexY;
  private double x, y;

  private static int RADIUS = 9;

  public Circle( int indexX, int indexY) {

    x = World.DIST_TO_00+(indexX*16)+(16-RADIUS)/2;
    y = World.DIST_TO_00+(indexY*16)+(16-RADIUS)/2;

    this.indexX = indexX;
    this.indexY = indexY;
  }

  public void draw(Graphics2D g){
    g.setColor(Color.green);
    g.fillOval((int)x, (int)y, RADIUS, RADIUS);

  }
}

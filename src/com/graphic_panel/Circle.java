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
    int alpha = 175; // ~254 = 100%
    Color myColour = new Color(32, 164, 32, alpha);
    
    g.setColor(myColour);
    g.fillOval((int)x, (int)y, RADIUS, RADIUS);

  }

  public int getIndexX() {
    return indexX;
  }

  public int getIndexY() {
    return indexY;
  }
}

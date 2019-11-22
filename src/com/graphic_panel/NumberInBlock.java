package com.graphic_panel;

import com.MainWindow;

import java.awt.*;

public class NumberInBlock {
  private int x;
  private int y;
  private int n;

  public NumberInBlock(int ix, int iy, int n) {
    this.x = World.DIST_TO_00 + (ix*MainWindow.BLOCKSIZE);
    this.y = World.DIST_TO_00 + 14 + (iy*MainWindow.BLOCKSIZE);
    this.n = n;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getN() {
    return n;
  }

  public void setN(int n) {
    this.n = n;
  }

  public void render(Graphics2D g) {
    Font font = new Font("TimesRoman", Font.ITALIC, 9);
    g.setFont(font);
    g.drawString(String.format("%d", this.n), this.x, this.y);

  }
}

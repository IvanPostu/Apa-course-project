package com.graphic_panel;



import com.MainWindow;

import java.awt.*;


public class Block extends GeometricObject {

  private Material material;

  public Block(Material material, int x, int y, int width, int height) {
    super(x, y, width, height);
    this.material = material;
  }

  public void update(){

  }

  public Point arrPos(){
    int x = (this.getX() - World.DIST_TO_00) / MainWindow.BLOCKSIZE;
    int y = (this.getY() - World.DIST_TO_00) / MainWindow.BLOCKSIZE;

    return new Point(x, y);
  }


  public void render(Graphics2D g){
    g.drawImage(this.material.getTexture(), x, y, null);
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public Material getMaterial() {
    return material;
  }
}

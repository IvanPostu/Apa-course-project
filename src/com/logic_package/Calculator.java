package com.logic_package;

import com.graphic_panel.Block;
import com.graphic_panel.Material;
import com.graphic_panel.World;
import com.window_panel.MenuPanel;

import java.awt.*;
import java.util.ArrayList;


public class Calculator {

  ArrayList<Block> boxes;
  ArrayList<Block> placesForBoxes;



  public Calculator() {
    boxes = new ArrayList<>();
    placesForBoxes = new ArrayList<>();
  }

  public void calculate(World world)throws Exception{

    boxes.clear();
    placesForBoxes.clear();

    Block[][] block = world.getBlocks();

    for(int i=0; i<block.length; i++){
      for(int k=0; k<block[0].length; k++){
        if(block[i][k].getMaterial()== Material.BOX)
          boxes.add(block[i][k]);
        else if (block[i][k].getMaterial()== Material.POS_FOR_BOX)
          placesForBoxes.add(block[i][k]);
      }
    }

    //TO DO test

    MenuPanel.println("Boxes:");
    for(Block a : boxes){
      Point p = a.arrPos();
      MenuPanel.println(String.format("ix=%d, iy=%d, x=%d, y=%d", p.x, p.y, a.getX(), a.getY()));
    }
    MenuPanel.println("Places for boxes:");
    for(Block a : placesForBoxes){
      MenuPanel.println(String.format("x=%d , y=%d", a.getX(), a.getY()));
    }

    //=======


  }


  public void draw(Graphics2D g) {
  }
}

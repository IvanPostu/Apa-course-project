package com.logic_package;

import com.graphic_panel.Block;
import com.graphic_panel.Material;
import com.graphic_panel.NumberInBlock;
import com.graphic_panel.World;
import com.window_panel.MenuPanel;

import java.awt.*;
import java.util.ArrayList;


public class Calculator {

  ArrayList<Block> boxes;
  ArrayList<Block> placesForBoxes;
  ArrayList<NumberInBlock> testNumbers;


  public Calculator() {
    boxes = new ArrayList<>();
    placesForBoxes = new ArrayList<>();
    testNumbers = new ArrayList<>();

    //testNumbers.add(new NumberInBlock(32+7,32+14,5));
    testNumbers.add(new NumberInBlock(0,0,5));
    testNumbers.add(new NumberInBlock(3,3,215));
    testNumbers.add(new NumberInBlock(5,2,25));
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
      Point p = a.arrPos();
      MenuPanel.println(String.format("ix=%d, iy=%d, x=%d, y=%d", p.x, p.y, a.getX(), a.getY()));
    }

    //=======


  }


  public void draw(Graphics2D g) {
    if(testNumbers!=null) {
      for (NumberInBlock n : testNumbers) n.render(g);
    }
  }
}

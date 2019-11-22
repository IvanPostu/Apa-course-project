package com.logic_package;

import com.graphic_panel.Block;
import com.graphic_panel.Material;
import com.graphic_panel.NumberInBlock;
import com.graphic_panel.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

  List<NumberInBlock> testNumbers;


  public Calculator() {
    testNumbers = new ArrayList<>();

    /*testNumbers.add(new NumberInBlock(0,0,5));
    testNumbers.add(new NumberInBlock(3,3,215));
    testNumbers.add(new NumberInBlock(5,2,25));*/
  }

  public void calculate(World world)throws Exception{

    testNumbers.clear();

    Block[][] blocks = world.getBlocks();
    Block robot = world.getRobot();

    int [][] ponderi  = new int[blocks.length][blocks[0].length];
    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        ponderi[i][k] = SearchPathWorkerImpl.INVIS_VAL_FOR_PATH;
      }
    }

    SearchPathWorker searchEngine = new SearchPathWorkerImpl();
    searchEngine.findFirstObject(world, ponderi,0, robot.arrPos().x, robot.arrPos().y, Material.BOX);
//    searchEngine.findFirstObject(world, ponderi,10, robot.arrPos().x+1, robot.arrPos().y, Material.BOX);
//    ponderi[1][1] = 22;

    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        if(ponderi[i][k]!=SearchPathWorkerImpl.INVIS_VAL_FOR_PATH){
          testNumbers.add(new NumberInBlock(i,k,ponderi[i][k]));
        }
      }
    }


  }


  public void clear(World world)throws Exception{
    Block blocks[][] = world.getBlocks();

    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        if(blocks[i][k].getMaterial()!=Material.ROBOT)
          blocks[i][k].setMaterial(Material.AIR);
      }
    }

    testNumbers.clear();



  }


  public void draw(Graphics2D g) {
    if(testNumbers!=null) {
      for (NumberInBlock n : testNumbers) n.render(g);
    }
  }
}

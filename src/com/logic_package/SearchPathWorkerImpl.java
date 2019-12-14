package com.logic_package;

import com.graphic_panel.Block;
import com.graphic_panel.Material;
import com.graphic_panel.World;
import com.window_panel.MenuPanel;

import java.util.ArrayList;
import java.util.Collections;

public class SearchPathWorkerImpl implements SearchPathWorker {
  
  public static final int INVISIBLE_WEIGHT = 999999;
  private static final int CORNER_WEIGHT = 14;//~14.1
  private static final int DIR_WEIGHT = 10;
  
  public SearchPathWorkerImpl() {
  
  }
  
  
  //TO DO: right top left right...
  @Override
  public void findAllPathWeight(World world, int[][] weight, int getWeight, int getX, int getY) {
    final int maxX = weight.length;
    final int maxY = weight[0].length;
    Block blocks[][] = world.getBlocks();
    
    //set pondere
    weight[getX][getY] = getWeight;
    
    //full right
    if (getX < maxX - 1) {
      if (weight[getX + 1][getY] > getWeight + DIR_WEIGHT) {
        if (blocks[getX + 1][getY].getMaterial() != Material.WALL) {
          weight[getX + 1][getY] = getWeight + DIR_WEIGHT;
          findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX + 1, getY);
        }
      }
      if (getY < maxY - 1) {
        if (weight[getX + 1][getY + 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX + 1][getY + 1].getMaterial() != Material.WALL) {
            weight[getX + 1][getY + 1] = getWeight + CORNER_WEIGHT;
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX + 1, getY + 1);
          }
        }
      }
      if (getY > 0) {
        if (weight[getX + 1][getY - 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX + 1][getY - 1].getMaterial() != Material.WALL) {
            weight[getX + 1][getY - 1] = getWeight + CORNER_WEIGHT;
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX + 1, getY - 1);
          }
        }
      }
    }
    //full left
    if (getX > 0) {
      if (weight[getX - 1][getY] > getWeight + DIR_WEIGHT) {
        if (blocks[getX - 1][getY].getMaterial() != Material.WALL) {
          weight[getX - 1][getY] = getWeight + DIR_WEIGHT;
          findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX - 1, getY);
        }
      }
      if (getY < maxY - 1) {
        if (weight[getX - 1][getY + 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX - 1][getY + 1].getMaterial() != Material.WALL) {
            weight[getX - 1][getY + 1] = getWeight + CORNER_WEIGHT;
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX - 1, getY + 1);
          }
        }
      }
      if (getY > 0) {
        if (weight[getX - 1][getY - 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX - 1][getY - 1].getMaterial() != Material.WALL) {
            weight[getX - 1][getY - 1] = getWeight + CORNER_WEIGHT;
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX - 1, getY - 1);
          }
        }
      }
    }
    
    //top and bottom
    if (getY < maxY - 1 && weight[getX][getY + 1] > getWeight + DIR_WEIGHT) {
      if (blocks[getX][getY + 1].getMaterial() != Material.WALL) {
        weight[getX][getY + 1] = getWeight + DIR_WEIGHT;
        findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX, getY + 1);
      }
    }
    if (getY > 0 && weight[getX][getY - 1] > getWeight + DIR_WEIGHT) {
      if (blocks[getX][getY - 1].getMaterial() != Material.WALL) {
        weight[getX][getY - 1] = getWeight + DIR_WEIGHT;
        findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX, getY - 1);
      }
    }
    
    
  }
  
  @Override
  public void connectTransitPoints(final ArrayList<Block> arr, int index) {
    if(index == arr.size())  {
    
    }
    
  }
  
  @Override
  public void recursTest(final ArrayList<Integer>arr, ArrayList<Integer>result, int index) {
  
    
    if(index==arr.size()){
      for(Integer z:result){
        MenuPanel.println(Integer.toString(z));
      }
      MenuPanel.println("");
      return;
    }
    
    for(Integer z:arr){
      if(result.indexOf(z)==-1){
        result.add(z);
        recursTest(arr, result, index+1);
        result.remove(result.size()-1);
      }
      
    }
    
  }
  
  
}

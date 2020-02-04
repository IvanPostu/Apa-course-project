package com.logic_package;

import com.graphic_panel.Block;
import com.graphic_panel.Material;
import com.graphic_panel.World;
import com.window_panel.MenuPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SearchPathWorkerImpl implements SearchPathWorker {
  
  public static final int INVISIBLE_WEIGHT = 999999;
  private static final int CORNER_WEIGHT = 14;//~14.1
  private static final int DIR_WEIGHT = 10;
  
  public SearchPathWorkerImpl() {
  
  }
  
  
  //TO DO: right top left right...
  @Override
  public void findAllPathWeight(World world, int[][] weight, int getWeight,
                                int getX, int getY) {
    
    final int maxX = weight.length;
    final int maxY = weight[0].length;
    Block blocks[][] = world.getBlocks();
    
    //set pondere
    weight[getX][getY] = getWeight;
    
    //full right
    if (getX < maxX - 1) {
      if (weight[getX + 1][getY] > getWeight + DIR_WEIGHT) {
        if (blocks[getX + 1][getY].getMaterial() != Material.WALL) {
          findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX + 1, getY);
        }
      }
      if (getY < maxY - 1) {
        if (weight[getX + 1][getY + 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX + 1][getY + 1].getMaterial() != Material.WALL) {
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX + 1, getY + 1);
          }
        }
      }
      if (getY > 0) {
        if (weight[getX + 1][getY - 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX + 1][getY - 1].getMaterial() != Material.WALL) {
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX + 1, getY - 1);
          }
        }
      }
    }
    //full left
    if (getX > 0) {
      if (weight[getX - 1][getY] > getWeight + DIR_WEIGHT) {
        if (blocks[getX - 1][getY].getMaterial() != Material.WALL) {
          findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX - 1, getY);
        }
      }
      if (getY < maxY - 1) {
        if (weight[getX - 1][getY + 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX - 1][getY + 1].getMaterial() != Material.WALL) {
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX - 1, getY + 1);
          }
        }
      }
      if (getY > 0) {
        if (weight[getX - 1][getY - 1] > getWeight + CORNER_WEIGHT) {
          if (blocks[getX - 1][getY - 1].getMaterial() != Material.WALL) {
            findAllPathWeight(world, weight, getWeight + CORNER_WEIGHT, getX - 1, getY - 1);
          }
        }
      }
    }
    
    //top and bottom
    if (getY < maxY - 1 && weight[getX][getY + 1] > getWeight + DIR_WEIGHT) {
      if (blocks[getX][getY + 1].getMaterial() != Material.WALL) {
        findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX, getY + 1);
      }
    }
    if (getY > 0 && weight[getX][getY - 1] > getWeight + DIR_WEIGHT) {
      if (blocks[getX][getY - 1].getMaterial() != Material.WALL) {
        findAllPathWeight(world, weight, getWeight + DIR_WEIGHT, getX, getY - 1);
      }
    }
    
    
  }
  
  @Override
  public void connectTransitPoints(final ArrayList<Block> arr, ArrayList<Block> dynamic,
                                   List<List<Block>> result, int index) {
    
    if (arr.size() == index) {
      result.add(new ArrayList<>(dynamic));
      return;
    }
    
    for (Block b : arr) {
      if (dynamic.indexOf(b) == -1) {
        dynamic.add(b);
//        recursTest(arr, dynamic, result, index+1);
        connectTransitPoints(arr, dynamic, result, index + 1);
        dynamic.remove(dynamic.size() - 1);
      }
    }
    
  }
  
  @Override
  public List<Block> findPathBetweenTwoPoint(Block A, Block B, World world) {
    
    List<Block> result = new ArrayList<>();
    Block[][] blocks = world.getBlocks();
    
    int[][] weight = new int[blocks.length][blocks[0].length];
    for (int i = 0; i < blocks.length; i++) {
      for (int k = 0; k < blocks[0].length; k++) {
        weight[i][k] = SearchPathWorkerImpl.INVISIBLE_WEIGHT;
      }
    }
    
    SearchPathWorker searchEngine = new SearchPathWorkerImpl();
    searchEngine.findAllPathWeight(world, weight, 0, A.arrPos().x, A.arrPos().y);


//    int weightForB = weight[B.arrPos().x][B.arrPos().y];
    Block block = B;
    
    do {
      
      block = aroundMinFinder(weight, blocks, block.arrPos().x, block.arrPos().y);
      result.add(block);
      
    } while (weight[block.arrPos().x][block.arrPos().y] != 14 && weight[block.arrPos().x][block.arrPos().y] != 10);
    
    
    return result;
  }
  
  private Block aroundMinFinder(int[][] weight, Block[][] blocks, final int getX, final int getY) {
    
    final int maxX = weight.length;
    final int maxY = weight[0].length;
    
    List<Block> possibleVariants = new ArrayList<>();
    
    
    //full right
    if (getX < maxX - 1) {

      possibleVariants.add(blocks[getX + 1][getY]);
      if (getY < maxY - 1) {

        possibleVariants.add(blocks[getX + 1][getY + 1]);
      }
      if (getY > 0) {

        possibleVariants.add(blocks[getX + 1][getY - 1]);
      }
    }
    //full left
    if (getX > 0) {

      possibleVariants.add(blocks[getX - 1][getY]);
      if (getY < maxY - 1) {

        possibleVariants.add(blocks[getX - 1][getY + 1]);
      }
      if (getY > 0) {

        possibleVariants.add(blocks[getX - 1][getY - 1]);
      }
    }
    
    //top and bottom
    if (getY < maxY - 1) {

      possibleVariants.add(blocks[getX][getY + 1]);
    }
    if (getY > 0) {

      possibleVariants.add(blocks[getX][getY - 1]);
    }
    
    Block variant = possibleVariants.get(0);
    int getWeight = weight[variant.arrPos().x][variant.arrPos().y];
    
    
    for (Block block : possibleVariants) {
      int ww = weight[block.arrPos().x][block.arrPos().y];
      
      if (ww < getWeight) {
        getWeight = ww;
        variant = block;
      }
    }
    
    
    Point p = variant.arrPos();
    
    return variant;
  }
  
  /*
* TO DO: TEST METHOD
* recursively passes through an array and saves all possible combinations
*
* Example:
*       ArrayList<Integer> aaa = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> t3 = new ArrayList<>();
        searchEngine.recursTest(aaa, new ArrayList<Integer>(), t3, 0 );
* */
  public void recursTest(final ArrayList<Integer> arr, ArrayList<Integer> dynamic,
                         List<List<Integer>> result, int index) {
    
    
    if (index == arr.size()) {
      
      result.add(new ArrayList<>(dynamic));
      return;
    }
    
    for (Integer z : arr) {
      if (dynamic.indexOf(z) == -1) {
        dynamic.add(z);
        recursTest(arr, dynamic, result, index + 1);
        dynamic.remove(dynamic.size() - 1);
      }
      
    }
    
  }
  
  
}

package com.logic_package;

import com.graphic_panel.Block;
import com.graphic_panel.Material;
import com.graphic_panel.World;

import java.util.ArrayList;
import java.util.List;

public interface SearchPathWorker {

  void findAllPathWeight(World world, int [][]weight, int getWeight, int getX, int getY);

  /*
  * TO DO: VERY IMPORTANT: First Element of arr is Robot
  *
  * */
  void connectTransitPoints(final ArrayList<Block> arr, ArrayList<Block> dynamic,
                            List<List<Block>> result, int index);
  
  
  List<Block> findPathBetweenTwoPoint(Block A, Block B, World world);
  
  
  

}

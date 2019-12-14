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
  
  
  /*
  * TO DO: TEST METHOD
  * recursively passes through an array and saves all possible combinations
  *
  * Example:
  *       ArrayList<Integer> aaa = new ArrayList<>(Arrays.asList(1,2,3));
          List<List<Integer>> t3 = new ArrayList<>();
          searchEngine.recursTest(aaa, new ArrayList<Integer>(), t3, 0 );
  * */
  void recursTest(final ArrayList<Integer>arr, ArrayList<Integer>dynamic,
                  List<List<Integer>> result, int index);
  
}

package com.logic_package;

import com.graphic_panel.Material;
import com.graphic_panel.World;

public interface SearchPathWorker {

  void findAllPathWeight(World world, int [][]weight, int getWeight, int getX, int getY);

}

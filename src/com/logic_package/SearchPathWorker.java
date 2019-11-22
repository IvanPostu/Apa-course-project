package com.logic_package;

import com.graphic_panel.Material;
import com.graphic_panel.World;

public interface SearchPathWorker {

  void findFirstObject(World world, int [][]ponderi, int getPondere, int getX, int getY, Material object);

}

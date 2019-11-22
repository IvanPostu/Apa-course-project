package com.logic_package;

import com.graphic_panel.Block;
import com.graphic_panel.Material;
import com.graphic_panel.World;

public class SearchPathWorkerImpl implements SearchPathWorker {

  public static final int INVIS_VAL_FOR_PATH = 999999;
  private static final int PONDERE_COLT = 14;//~14.1
  private static final int PONDERE_DIR = 10;

  public SearchPathWorkerImpl() {

  }


  //TO DO: right top left right...
  @Override
  public void findFirstObject(World world, int[][] ponderi, int getPondere, int getX, int getY, Material object) {
    final int maxX = ponderi.length;
    final int maxY = ponderi[0].length;
    Block blocks[][] = world.getBlocks();

    //set pondere
    ponderi[getX][getY] = getPondere;

    //full right
    if (getX < maxX - 1) {
      if (ponderi[getX + 1][getY] > getPondere + PONDERE_DIR) {
        if (blocks[getX + 1][getY].getMaterial() != Material.WALL) {
          ponderi[getX + 1][getY] = getPondere + PONDERE_DIR;
          findFirstObject(world, ponderi, getPondere + PONDERE_DIR, getX + 1, getY, object);
        }
      }
      if (getY < maxY - 1) {
        if (ponderi[getX + 1][getY + 1] > getPondere + PONDERE_COLT) {
          if (blocks[getX + 1][getY + 1].getMaterial() != Material.WALL) {
            ponderi[getX + 1][getY + 1] = getPondere + PONDERE_COLT;
            findFirstObject(world, ponderi, getPondere + PONDERE_COLT, getX + 1, getY + 1, object);
          }
        }
      }
      if (getY > 0) {
        if (ponderi[getX + 1][getY - 1] > getPondere + PONDERE_COLT) {
          if (blocks[getX + 1][getY - 1].getMaterial() != Material.WALL) {
            ponderi[getX + 1][getY - 1] = getPondere + PONDERE_COLT;
            findFirstObject(world, ponderi, getPondere + PONDERE_COLT, getX + 1, getY - 1, object);
          }
        }
      }
    }
    //full left
    if (getX > 0) {
      if (ponderi[getX - 1][getY] > getPondere + PONDERE_DIR) {
        if (blocks[getX - 1][getY].getMaterial() != Material.WALL) {
          ponderi[getX - 1][getY] = getPondere + PONDERE_DIR;
          findFirstObject(world, ponderi, getPondere + PONDERE_DIR, getX - 1, getY, object);
        }
      }
      if (getY < maxY - 1) {
        if (ponderi[getX - 1][getY + 1] > getPondere + PONDERE_COLT) {
          if (blocks[getX - 1][getY + 1].getMaterial() != Material.WALL) {
            ponderi[getX - 1][getY + 1] = getPondere + PONDERE_COLT;
            findFirstObject(world, ponderi, getPondere + PONDERE_COLT, getX - 1, getY + 1, object);
          }
        }
      }
      if (getY > 0) {
        if (ponderi[getX - 1][getY - 1] > getPondere + PONDERE_COLT) {
          if (blocks[getX - 1][getY - 1].getMaterial() != Material.WALL) {
            ponderi[getX - 1][getY - 1] = getPondere + PONDERE_COLT;
            findFirstObject(world, ponderi, getPondere + PONDERE_COLT, getX - 1, getY - 1, object);
          }
        }
      }
    }

    //top and bottom
    if (getY < maxY - 1 && ponderi[getX][getY + 1] > getPondere + PONDERE_DIR) {
      if (blocks[getX][getY + 1].getMaterial() != Material.WALL) {
        ponderi[getX][getY + 1] = getPondere + PONDERE_DIR;
        findFirstObject(world, ponderi, getPondere + PONDERE_DIR, getX, getY + 1, object);
      }
    }
    if (getY > 0 && ponderi[getX][getY - 1] > getPondere + PONDERE_DIR) {
      if (blocks[getX][getY - 1].getMaterial() != Material.WALL) {
        ponderi[getX][getY - 1] = getPondere + PONDERE_DIR;
        findFirstObject(world, ponderi, getPondere + PONDERE_DIR, getX, getY - 1, object);
      }
    }


  }


}

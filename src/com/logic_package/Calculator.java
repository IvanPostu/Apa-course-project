package com.logic_package;

import com.graphic_panel.*;
import com.other_package.CustomPair;
import com.window_panel.MenuPanel;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Calculator {


  /*
  * TO DO: path weight array for show to UI
  *
  * */
  private List<NumberInBlock> pathWeight;

  /*
   *TO DO: mark path
   *
   * */
  private List<Circle> pathMark;

  /*
  * TO DO: Block - transitPoint AND get block weight
  *
  * */
  List<CustomPair<Block, Integer>> transitPoint;

  public Calculator() {
    pathWeight = new LinkedList<>();
    pathMark = new LinkedList<>();
    transitPoint = new ArrayList<>();

//    path.add(new Circle(1,1));
//    path.add(new Circle(1,3));

  }

  public void calculate(World world)throws Exception{

    pathWeight.clear();

    Block[][] blocks = world.getBlocks();
    Block robot = world.getRobot();



    int [][] weight  = new int[blocks.length][blocks[0].length];
    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        weight[i][k] = SearchPathWorkerImpl.INVISIBLE_WEIGHT;
      }
    }

    SearchPathWorker searchEngine = new SearchPathWorkerImpl();
    searchEngine.findFirstObject(world, weight,0, robot.arrPos().x,
            robot.arrPos().y, Material.BOX);

    /*TO DO:  adds blocks to be passed into a separate array */
    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        if(blocks[i][k].getMaterial()==Material.BOX
                && weight[i][k]!=SearchPathWorkerImpl.INVISIBLE_WEIGHT)
          transitPoint.add(new CustomPair<Block, Integer>(blocks[i][k], weight[i][k]));
      }
    }


    transitPoint.forEach( a -> {
      MenuPanel.println("Transit point "+
              Integer.toString(a.getFirst().arrPos().x)+" "+
              Integer.toString(a.getFirst().arrPos().y));
    });


    /*TO DO:  conversion weight[][] to an array of type NumberInBlock for show to UI*/
    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        if(weight[i][k]!=SearchPathWorkerImpl.INVISIBLE_WEIGHT){
          pathWeight.add(new NumberInBlock(i,k,weight[i][k]));
        }
      }
    }


  }


  public void clear(World world)throws Exception{
    Block[][] blocks = world.getBlocks();

    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        if(blocks[i][k].getMaterial()!=Material.ROBOT)
          blocks[i][k].setMaterial(Material.AIR);
      }
    }

    pathWeight.clear();



  }


  public void draw(Graphics2D g) {
    if(pathWeight !=null) {
      for (NumberInBlock n : pathWeight) n.render(g);
    }

    if(pathMark !=null){
      for(Circle c : pathMark) c.draw(g);
    }


    double radius = 2.;

  }
}

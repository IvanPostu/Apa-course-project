package com.logic_package;

import com.graphic_panel.*;
import com.other_package.CustomPair;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Calculator {

  List<NumberInBlock> testNumbers;
  List<Circle> path;



  /*
  * TO DO: Block - transitPoint AND get block weight
  *
  * */
  List<CustomPair<Block, Integer>> transitPoint;

  public Calculator() {
    testNumbers = new LinkedList<>();
    path = new LinkedList<>();
    transitPoint = new ArrayList<>();

//    path.add(new Circle(1,1));
//    path.add(new Circle(1,3));

  }

  public void calculate(World world)throws Exception{

    testNumbers.clear();

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
                && weight[i][ k]!=SearchPathWorkerImpl.INVISIBLE_WEIGHT){}
//          transitPoint.add(blocks[i][k]);
      }
    }


//    transitPoint.forEach( a -> {
//      MenuPanel.println("Transit point "+
//              Integer.toString(a.arrPos().x)+" "+Integer.toString(a.arrPos().y));
//    });


    /*TO DO:  conversion weight[][] to an array of type NumberInBlock for show to UI*/
    for(int i=0; i<blocks.length; i++){
      for(int k=0; k<blocks[0].length; k++){
        if(weight[i][k]!=SearchPathWorkerImpl.INVISIBLE_WEIGHT){
          testNumbers.add(new NumberInBlock(i,k,weight[i][k]));
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

    testNumbers.clear();



  }


  public void draw(Graphics2D g) {
    if(testNumbers!=null) {
      for (NumberInBlock n : testNumbers) n.render(g);
    }

    if(path!=null){
      for(Circle c : path) c.draw(g);
    }


    double radius = 2.;

  }
}

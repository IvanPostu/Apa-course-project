package com.graphic_panel;


import com.MainWindow;
import com.window_panel.MenuPanel;

import java.awt.*;

public class World {

    private Block[][] blocks;
    private Block robot;

    public static final int BLOCKS = 30;
    public static final int DIST_TO_00 = 32;

    public World() {
        blocks = new Block[BLOCKS][BLOCKS];

        for (int i = 0; i < BLOCKS; i++) {
            for (int j = 0; j < BLOCKS; j++) {
                blocks[i][j] = new Block(Material.AIR,
                        DIST_TO_00+(i*16), DIST_TO_00+(j*16), 16, 16
                );
            }
        }

        robot = blocks[0][0];
        robot.setMaterial(Material.ROBOT);
    }

    public void render(Graphics2D g){

        for (int i = 0; i < BLOCKS; i++) {
            for (int j = 0; j < BLOCKS; j++) {
                blocks[i][j].render(g);
            }
        }

    }

    public Block getBlock(int x, int y){

        for (int i = 0; i < BLOCKS; i++) {
            for (int j = 0; j < BLOCKS; j++) {
                Rectangle rect = blocks[i][j].getBox();
                if(x>=rect.x&&x<rect.x+ MainWindow.BLOCKSIZE && y>=rect.y&&y<rect.y+ MainWindow.BLOCKSIZE){
                    return blocks[i][j];
                }

            }
        }

        return null;
    }

    public void worldMouseKeyPresed(int x, int y){
        String s  = String.format("x=%d, y=%d", x, y);

        MenuPanel.println(s);

        Block block = getBlock(x, y);
        if(block.getMaterial()==Material.ROBOT) return;

        if(MenuPanel.worldEditMenu.isAddWall()){
            block.setMaterial(Material.WALL);
        }else if(MenuPanel.worldEditMenu.isAddSpace()){
            block.setMaterial(Material.AIR);
        }else if(MenuPanel.worldEditMenu.isAddBox()){
            block.setMaterial(Material.BOX);
        }else if(MenuPanel.worldEditMenu.isAddBoxPlace()){
            block.setMaterial(Material.POS_FOR_BOX);
        }else if(MenuPanel.worldEditMenu.isAddRobot()){

            //TO DO: Swap robot and other block...

            int tempX = robot.getX();
            int tempY = robot.getY();
            Point robotPos = robot.arrPos();
            Point blockPos = block.arrPos();

            robot.setX(block.getX());
            robot.setY(block.getY());

            block.setX(tempX);
            block.setY(tempY);


            blocks[robotPos.x][robotPos.y] = block;
            blocks[blockPos.x][blockPos.y] = robot;

        }

    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public Block getRobot() {
        return robot;
    }
}

package com.graphic_panel;

import com.MainWindow;

import java.awt.image.BufferedImage;

public enum Material {

    AIR(0, true),
    WALL(1, false),
    BOX(2, true),
    POS_FOR_BOX(3, true),
    ROBOT(4, true);

    private int id;
    private boolean walkable;
    private BufferedImage image;

    private Material(int id, boolean walkable) {
        this.id = id;
        this.walkable = walkable;
        this.image  = MainWindow.sprite.getTexture(id);
    }

    public int getId(){
        return this.id;
    }

    public boolean isWalkable(){
        return this.walkable;
    }

    public BufferedImage getTexture(){
        return image;
    }

}

package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

    private int width;
    private int height;
    private int cols;
    private BufferedImage sprite;

    public Spritesheet(BufferedImage sprite, int width, int height, int cols) {
        this.cols = cols;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public BufferedImage getTexture(int id) {

        int row = (id / cols) ;
        int col = (id % cols) ;

        return sprite.getSubimage(col*width, row*height, width, height);
    }

    public BufferedImage getTexture(int col, int row){
        return sprite.getSubimage(col*width,row*height, width, height);
    }


}

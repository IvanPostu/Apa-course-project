package com.graphic_panel;

import java.awt.*;

public abstract class GeometricObject {
    protected int x, y;
    protected int width, height;

    public GeometricObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Rectangle getBox(){
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(x, y, width, height );
        return rectangle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

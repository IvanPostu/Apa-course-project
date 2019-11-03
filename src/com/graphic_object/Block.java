package com.graphic_object;



import java.awt.*;

public class Block extends GraphicObject {

    private Material material;

    public Block(Material material, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.material = material;
    }

    public void update(){

    }

    public void render(Graphics2D g){
        g.drawImage(this.material.getTexture(), (int)x, (int)y, null);
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }
}

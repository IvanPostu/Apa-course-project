package com;

import com.graphic_panel.GraphicPanel;
import com.other_package.ImageLoader;
import com.other_package.Spritesheet;
import com.window_panel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static Spritesheet sprite = new Spritesheet(ImageLoader.load(
            "img/blocks.png"),16, 16, 5
    );
    public static final int BLOCKSIZE = 16;

    public static MenuPanel menuPanel;


    public MainWindow(){
        super();
        menuPanel = new MenuPanel(0, 0, 200, 600);

        add(new GraphicPanel(200, 0, 600, 600));
        add(menuPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Path F1nder");
        setSize(new Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        setVisible(true);
    }

}

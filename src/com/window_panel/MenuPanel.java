package com.window_panel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanel extends JPanel {

  public static WorldEditMenu worldEditMenu;


  public MenuPanel(int x, int y, int width, int height) {
    super();
    setBackground(Color.gray);
    setBounds(x, y, width, height);
    setLayout(null);

    worldEditMenu = new WorldEditMenu();
    add(worldEditMenu);



    //add border
    Border border = BorderFactory.createLineBorder(Color.black);
    setBorder(border);

  }

  public static void println(String s ){
    if(worldEditMenu!=null) worldEditMenu.println(s);
  }

}

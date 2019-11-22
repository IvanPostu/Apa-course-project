package com.window_panel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

  public static WorldEditMenu worldEditMenu;

  private JButton runButton;
  private JButton clearButton;

  public MenuPanel(int x, int y, int width, int height) {
    super();
    setBackground(Color.gray);
    setBounds(x, y, width, height);
    setLayout(null);

    worldEditMenu = new WorldEditMenu();
    add(worldEditMenu);

    runButton = new JButton("Run");
    runButton.setBounds(55, 525, 50, 35);
    runButton.setBackground(Color.green);
    runButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));

    clearButton = new JButton("Clear");
    clearButton.setBounds(110, 525, 40, 35);
    clearButton.setBackground(Color.red);
    clearButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));

    add(runButton);
    add(clearButton);


    setBorder(BorderFactory.createLineBorder(Color.black));

  }

  public static void println(String s ){
    if(worldEditMenu!=null) worldEditMenu.println(s);
  }

  public JButton getRunButton() {
    return runButton;
  }

  public JButton getClearButton() {
    return clearButton;
  }
}

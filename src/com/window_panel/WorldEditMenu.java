package com.window_panel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class WorldEditMenu extends JPanel {

  private JCheckBox worldEdit;
  private JCheckBox addWall, addSpace, addBox, addBoxPlace, addRobot;

  private JCheckBox showNumbers;
  
  private JTextArea txtArea;
  private JScrollPane scrollPaneForTxtArea;
  private JButton clearTxtAreaBtn;


  public WorldEditMenu() {
    setBackground(Color.gray);
    setBounds(0,0, 200, 200);
    setLayout(null);

    worldEdit = new JCheckBox("Edit Mode");
    worldEdit.setBounds(100-40, 10, 95, 20);
    worldEdit.setBackground(Color.gray);
    worldEdit.setSelected(true);
    worldEdit.addItemListener((ItemEvent e)->checkboxClickListener(e));
    add(worldEdit);

    addWall = new JCheckBox("Add Wall");
    addWall.setBounds(5, 10+20, 95, 20);
    addWall.setBackground(Color.gray);
    addWall.setSelected(false);
    addWall.addItemListener((ItemEvent e)->checkboxClickListener(e));
    add(addWall);

    addSpace = new JCheckBox("Add Space");
    addSpace.setBounds(100, 10+20, 95, 20);
    addSpace.setBackground(Color.gray);
    addSpace.setSelected(false);
    addSpace.addItemListener((ItemEvent e)->checkboxClickListener(e));
    add(addSpace);

    addBox = new JCheckBox("Add Box");
    addBox.setBounds(5, 10+20+25, 95, 20);
    addBox.setBackground(Color.gray);
    addBox.setSelected(false);
    addBox.addItemListener((ItemEvent e)->checkboxClickListener(e));
    add(addBox);

    addBoxPlace = new JCheckBox("Add Box Place");
    addBoxPlace.setBounds(100, 10+20+25, 95, 20);
    addBoxPlace.setBackground(Color.red);
    addBoxPlace.setSelected(false);
    addBoxPlace.addItemListener((ItemEvent e)->checkboxClickListener(e));
//    add(addBoxPlace);

    addRobot = new JCheckBox("Move Robot");
    addRobot.setBounds(5, 10+20+25+25, 95, 20);
    addRobot.setBackground(Color.gray);
    addRobot.setSelected(true);
    addRobot.addItemListener((ItemEvent e)->checkboxClickListener(e));
    add(addRobot);
  
    showNumbers = new JCheckBox("Show Numbers");
    showNumbers.setBounds(5, 10+20+25+25+25, 110, 20);
    showNumbers.setBackground(Color.gray);
    showNumbers.setSelected(true);
    add(showNumbers);

    txtArea = new JTextArea();
    txtArea.setBackground(Color.lightGray);
    txtArea.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        int counter = 0;
        final int MAX_COUNTER = 22;
        for (int i = 0; i < txtArea.getText().length(); i++) {
          counter++;
          if(txtArea.getText().charAt(i)=='\n') counter = 0;
        }

        if(counter == MAX_COUNTER)txtArea.setText(txtArea.getText()+"\n");


        //if (txtArea.getText().length() % 10 ==0 && txtArea.getText().length()>1 )txtArea.setText(txtArea.getText()+"\n");
      }
    });

    scrollPaneForTxtArea = new JScrollPane(txtArea);
    scrollPaneForTxtArea.setBounds(5, 30, 190, 150);
    scrollPaneForTxtArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPaneForTxtArea.setVisible(false);
    add(scrollPaneForTxtArea);

    clearTxtAreaBtn = new JButton("Clear");
    clearTxtAreaBtn.setBounds(5, 182, 70, 16);
    clearTxtAreaBtn.setBackground(Color.white);
    clearTxtAreaBtn.setVisible(false);
    clearTxtAreaBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        txtArea.setText("");
      }
    });
    add(clearTxtAreaBtn);

    Border border = BorderFactory.createLineBorder(Color.darkGray);
    setBorder(border);
  }


  private void checkboxClickListener(ItemEvent e){
    JCheckBox []arr = new  JCheckBox[]{addWall, addSpace, addBox, addBoxPlace, addRobot};
    JCheckBox obj = (JCheckBox)e.getItem();
    boolean isSelected = e.getStateChange()==ItemEvent.SELECTED;

    if(obj == worldEdit ){
      if(!isSelected){
        for (JCheckBox item: arr) {
          item.setVisible(false);
        }
        showNumbers.setVisible(false);
        scrollPaneForTxtArea.setVisible(true);
        clearTxtAreaBtn.setVisible(true);
      }else{
        for (JCheckBox item: arr) {
          item.setVisible(true);
        }
        showNumbers.setVisible(true);
        scrollPaneForTxtArea.setVisible(false);
        clearTxtAreaBtn.setVisible(false);
      }
    }else{
      if(isSelected){
        for (JCheckBox item: arr) {
          if(item!=obj) item.setSelected(false);
        }
      }
    }
  }


  public boolean isAddWall(){
    return this.addWall.isSelected();
  }

  public boolean isAddSpace (){
    return this.addSpace.isSelected();
  }

  public boolean isAddBox(){
    return this.addBox.isSelected();
  }

  public boolean isAddBoxPlace(){
    return this.addBoxPlace.isSelected();
  }

  public boolean isAddRobot(){
    return this.addRobot.isSelected();
  }

  public boolean isWorldEdit(){
    return this.worldEdit.isSelected();
  }

  public boolean isShowNumbers(){
    return this.showNumbers.isSelected();
  }
  
  
  public void println(String s) {
    this.txtArea.append(s+"\n");
  }
}

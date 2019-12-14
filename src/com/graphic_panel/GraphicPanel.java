package com.graphic_panel;

import com.window_panel.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.VolatileImage;

public class GraphicPanel extends JPanel implements  ActionListener, KeyListener, MouseListener, MouseMotionListener{

    public static final float SCALE = 1.f;

    public static int width;
    public static int height;

    private Timer timer;
    private VolatileImage image;
    private Playstate playstate;

    public GraphicPanel(int x, int y, int width, int height) {
        super();
        setBackground(Color.DARK_GRAY);
        setBounds(x, y, width, height);
        setPreferredSize(new Dimension(width, height));

        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

        GraphicPanel.width = getPreferredSize().width;
        GraphicPanel.height = getPreferredSize().height;

        playstate = new Playstate();

    }

    @Override
    public void addNotify(){
        super.addNotify();
        image = createVolatileImage((int)(width/SCALE), (int)(height/SCALE));
        this.timer = new Timer(1000/60, this);
        this.timer.start();
    }

    private void update(){
        playstate.update();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        update();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = image.createGraphics();
        g2.setBackground(new Color(146, 189, 221));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING	, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        playstate.render(g2);
        g.drawImage(this.image.getScaledInstance(width, height, Image.SCALE_FAST),
                0, 0, null
        );

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        playstate.mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        playstate.mouseReleased(mouseEvent);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        playstate.keyPressed(e, e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        playstate.keyReleased(e, e.getKeyCode());
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        playstate.mouseMoved(e);
    }
}

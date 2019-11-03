package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.VolatileImage;

public class GraphicPanel extends JPanel implements  ComponentListener, ActionListener, KeyListener, MouseListener  {

    public static final float SCALE = 1.f;
    //public static final int DIST_FROM_00 = 3*MainWindow.BLOCKSIZE;

    public static int width;
    public static int height;

    private Timer timer;
    private VolatileImage image;
    private GraphicStateManager gsm;


    public GraphicPanel(int x, int y, int width, int height) {
        super();
        setBackground(Color.DARK_GRAY);
        setBounds(x, y, width, height);
        setPreferredSize(new Dimension(width, height));

        addComponentListener(this);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

        GraphicPanel.width = getPreferredSize().width;
        GraphicPanel.height = getPreferredSize().height;

        this.gsm = new GraphicStateManager(GraphicStateManager.PLAYSTATE);
    }

    @Override
    public void addNotify(){
        super.addNotify();
        image = createVolatileImage((int)(width/SCALE), (int)(height/SCALE));
        this.timer = new Timer(1000/60, this);
        this.timer.start();
    }

    public void update(){
        gsm.update();
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
        gsm.render(g2);
        g.drawImage(this.image.getScaledInstance(width, height, Image.SCALE_FAST),
                0, 0, null
        );

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        gsm.mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        gsm.mouseReleased(mouseEvent);
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
        gsm.keyPressed(e, e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e, e.getKeyCode());
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {

    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {

    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {

    }

    @Override
    public void componentHidden(ComponentEvent componentEvent) {

    }
}

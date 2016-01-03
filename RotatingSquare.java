package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 16-1-3
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */

class SquareRotate extends JPanel{
    private Rectangle2D square = new Rectangle2D.Float(-50f,-50f,100f,100f);
    private AffineTransform rot = new AffineTransform();
    private AffineTransform    scale = new AffineTransform();
    private volatile int speed;
    private int boxSize;
    public SquareRotate(){
        setSpeed(5);
        setBoxSize(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    SquareRotate.this.repaint();
                    try{
                        Thread.sleep(1000/speed);
                    }catch (InterruptedException e){
                }
            }}
        }).start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g ;
        g2.translate(getWidth()/2,getHeight()/2);
        g2.scale(boxSize/10.0,boxSize/10.0);
        g2.setPaint(Color.black);
        rot.rotate(Math.toRadians(20));
        g2.transform(rot);
        g2.draw(square);
    }
    public void setSpeed(int speed){this.speed = speed;}
    public void setBoxSize(int boxSize){
        this.boxSize = boxSize;
    }

}

public class RotatingSquare extends JFrame {
    private SquareRotate squareRotate = new SquareRotate();
    private JSlider adjustSpeed = new JSlider(1,10,5);
    private JSlider adjustBoxSize = new JSlider(1,20,10);
    public RotatingSquare(){
        add(squareRotate);
        adjustBoxSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                squareRotate.setBoxSize(adjustBoxSize.getValue());
            }
        });
        adjustSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                squareRotate.setSpeed(adjustSpeed.getValue());
            }
        });
        JPanel slider = new JPanel();
        slider.setLayout(new GridLayout(2,1));
        slider.add(adjustBoxSize);
        slider.add(adjustSpeed);
        add(BorderLayout.SOUTH,slider);


    }
    public static void main(String[] args){
        SwingConsole.run(new RotatingSquare(),400,400);

    }

}

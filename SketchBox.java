package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 16-1-3
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
class SketchArea extends JPanel{
    List<Point> points = new ArrayList<Point>();
    class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void addPoint(int x, int y){
        points.add(new Point(x,y));
        repaint();
    }
    public void clear(){
        points.clear();
        repaint();
    }
    Point previousPoint;
    void drawPoint(Graphics graphics,Point p){
        if (previousPoint == null){
            previousPoint = p;
            return;
        }
        graphics.drawLine(previousPoint.x,previousPoint.y,p.x,p.y);
        previousPoint = p;
    }

    public void paintComponent(Graphics g ){
        super.paintComponent(g);
        g.setColor(Color.black);
        previousPoint = null;
        for (Point p:points){
            drawPoint(g,p);
        }
    }

}
public class SketchBox extends JFrame{
    SketchArea sketchArea = new SketchArea();
    JSlider hAxis = new JSlider(),
    vAxis = new JSlider();
    JButton erase = new JButton("Erase");
    ChangeListener cl = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            sketchArea.addPoint(hAxis.getValue(),vAxis.getValue());
            erase.setText("point.size() = "+sketchArea.points.size());
        }
    };
    public SketchBox(){
        add(sketchArea);
        hAxis.setValue(0);
        vAxis.setValue(0);
        vAxis.setInverted(true);
        hAxis.addChangeListener(cl);
        vAxis.addChangeListener(cl);
        add(BorderLayout.SOUTH,hAxis);
        add(BorderLayout.WEST,vAxis);
        add(BorderLayout.NORTH,erase);
        erase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sketchArea.clear();
                erase.setText("point.size()"+sketchArea.points.size());
            }
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);    //To change body of overridden methods use File | Settings | File Templates.
                hAxis.setMaximum(sketchArea.getWidth());
                vAxis.setMaximum(sketchArea.getHeight());
            }
        });
    }
    public static void main(String[] args){
        SwingConsole.run(new SketchBox(),700,400);
    }
}

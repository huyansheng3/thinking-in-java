package com.company;
//: gui/SineWave.java
// Drawing with Swing, using a JSlider.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;



    class SineDraw extends JPanel{
        private static final int SACLEFACTOR = 100;     //系数因子
        private int points;
        private int cycles;
        private double[] sines;
        private int[] pts;
        public SineDraw(){setCycles(5);}
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int maxWidth = getWidth();
            double hstep = (double) maxWidth/ (double)points;
            int maxHeight = getHeight();
            pts = new int[points];
            for (int i = 0;i<points;i++){
                pts[i] = (int) (sines[i]*maxHeight/2*0.5+maxHeight/2);
            }
            g.setColor(Color.black);
            for (int i = 1;i<points;i++){
                int x1 = (int)((i-1)*hstep) ;
                int x2 = (int)(i*hstep);
                int y1 = pts[i-1];
                int y2 = pts[i];
                g.drawLine(x1,y1,x2,y2);
            }

        }
        public int getCycles(){
            return this.cycles;
        }
        public int getPoints(){
            return this.points;
        }
        public void setPoints(){
            this.points = SACLEFACTOR*cycles*2;
        }
        public void setSines(){
            setPoints();
            sines = new double[points];
            for (int i = 0 ;i<points;i++){
                double radians = (Math.PI / SACLEFACTOR)*i;
                sines[i] = Math.sin(radians);
            }
            repaint();
        }
        public void setCycles(int newCycles){
            this.cycles = newCycles;
            setPoints();
            sines = new double[points];
            for (int i = 0 ;i<points;i++){
                double radians = (Math.PI / SACLEFACTOR)*i;
                sines[i] = Math.sin(radians);
            }
            repaint();
        }
    }

public class SineWave extends JFrame{
    SineDraw sineDraw = new SineDraw();
    private JSlider adjustCycles = new JSlider(1, 30, 5);
    public SineWave(){
        add(sineDraw);
        adjustCycles.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sineDraw.setCycles(((JSlider)e.getSource()).getValue());
            }
        });
        add(BorderLayout.SOUTH,adjustCycles);
    }
    public static void main(String[] args) {
        SwingConsole.run(new SineWave(), 700, 400);
    }
} ///:~

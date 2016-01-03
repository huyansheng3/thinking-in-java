package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 16-1-2
 * Time: 上午9:48
 * To change this template use File | Settings | File Templates.
 */
public class Button3b extends JFrame {
    private JButton b1 = new JButton("Button1"),
    b2 = new JButton("Button2"),
    b3 = new JButton("Button3");
    private JTextField text = new JTextField(10);
    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            text.setText(name);
        }
    };
    public Button3b(){
        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(text);
    }
    public static void main(String[] args){
        SwingConsole.run(new Button3b(), 200, 150);
    }
}

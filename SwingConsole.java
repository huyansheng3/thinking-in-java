package com.company;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 16-1-2
 * Time: 上午9:45
 * To change this template use File | Settings | File Templates.
 */
public class SwingConsole {
    public static void run(final JFrame f,final int width,final int height){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width,height);
                f.setVisible(true);
            }
        });
    }
}

package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 15-12-25
 * Time: 下午10:54
 * To change this template use File | Settings | File Templates.
 */
class UnresponsiveUI{
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception{
        while (d>0){
            d = d+(Math.PI+Math.E)/d;
        }
        System.in.read();  //Never run to here
    }
}
public class ResponsiveUI extends Thread{
    private static volatile double d = 1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }
    @Override
    public void run() {
        while (true){
            d = d+(Math.PI+Math.E)/d;
        }
    }

    public static void main(String[] args)throws Exception{
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}

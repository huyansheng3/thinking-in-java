package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 15-12-23
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10; //if does not use the second constructor ,it will use the default count
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){

    }
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown > 0?countDown:"LiftOff!")+"),";
    }
    @Override
    public void run() {
        while (countDown-->0){
            System.out.println(status());
            Thread.yield(); //this meaning that i have finish my work,the others thread can do his work now!
            //it can make the thread executor work better!
        }
    }
}

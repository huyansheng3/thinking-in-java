package com.company;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: huyansheng
 * Date: 15-12-23
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class RandomSleepingTask extends LiftOff{
    Random random = new Random();
    int randInt = random.nextInt(10);
    @Override
    public void run() {
        try {
            while (countDown-->0){
                TimeUnit.MICROSECONDS.sleep(randInt);
                System.out.println("i have sleep : "+randInt+" second");
                //System.out.println(status());
            }
        }catch (InterruptedException e){
            System.err.println("Interrupt");
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0;i<5;i++){
            exec.execute(new RandomSleepingTask());
        }
        exec.shutdown();
    }
}

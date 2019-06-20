package com.chenbing.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConCurrentTest {

    private int count =1;

    private synchronized  void add(){
        count++;

        System.out.println(Thread.currentThread().getName()+"执行++count值为:"+count);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized  void minus(){
        count--;

        System.out.println(Thread.currentThread().getName()+"执行--count值为:"+count);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(4) ;
        ConCurrentTest t = new ConCurrentTest();
        AddThread add = t.new AddThread();
        MinusThread minus = t.new MinusThread();
        for(int i =0; i<2; i++){
            Thread t1 = new Thread(add);
            t1.start();
            Thread t2 = new Thread(minus);
            t2.start();
        }
//        System.out.println(t.count);

    }

    /**
     * 加线程
     */
    public class AddThread implements Runnable{


        @Override
        public void run() {
            for(int i=0; i<3; i++){
                add();
            }
        }
    }

    public class MinusThread implements Runnable{

        @Override
        public void run() {
            for(int j=0; j<3; j++){
                minus();
            }
        }
    }
}

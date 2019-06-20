package com.chenbing.test;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class ThreadPoolTest {
    public static Executor service = null;

    public static void main(String[] args) {
        for(int i = 0;i<20;i++){
            service.execute(new Task());
        }
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

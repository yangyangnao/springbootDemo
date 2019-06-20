package com.chenbing.test;

public class SingletonDC {

    private volatile static SingletonDC singletonDC;
    /**
     * double check模式
     */
    private SingletonDC(){

    }

    public static SingletonDC getSingletonDC() {
        if(singletonDC == null){
            synchronized (SingletonDC.class) {
                if (singletonDC == null) {
                    singletonDC = new SingletonDC();
                }
            }
        }
        return singletonDC;
    }
}

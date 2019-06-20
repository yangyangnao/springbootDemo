package com.chenbing.test;

public class HashTest {
    public static void main(String[] args) {
        String s = "陈兵";
        int i = 1;
        Integer it = 20;
        Object o = new Object();
        System.out.println(s.hashCode());
        System.out.println(o.hashCode());
        System.out.println(it.hashCode());
    }
}

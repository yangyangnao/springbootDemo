package com.chenbing.test;

import java.util.LinkedList;
import java.util.Queue;

public class JdkQueueTest {

    public static void main (String[]args ){
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("d");
        queue.offer("b");
        queue.offer("e");
        for(String s : queue){
            System.out.print(s);
        }
        System.out.print("查看offer完成");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }

        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
    }

}

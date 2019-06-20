package com.chenbing.test;

public class LblAndSlblTest {
    public static void main(String[] args) {
        LblAndSlbl.eyeNum = 100;
        System.out.println("类变量:属于类本身,只要类初始化完成,程序即可使用该变量："+LblAndSlbl.eyeNum);

        LblAndSlbl sl1 = new LblAndSlbl();
        sl1.age=10;
        sl1.name="tom";
        System.out.println("通过sl1变量访问eyeNum类变量：" + sl1.eyeNum);
        sl1.info();


        LblAndSlbl sl12 = new LblAndSlbl();
        sl12.age=20;
        sl12.name="jack";
        System.out.println("通过sl12变量访问eyeNum类变量：" + sl12.eyeNum);
        sl12.info();

    }
}

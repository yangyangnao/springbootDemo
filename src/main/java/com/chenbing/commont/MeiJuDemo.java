package com.chenbing.commont;

public class MeiJuDemo {
    //定义一个enum型的对象.enum对象的值都会自动获得一个数字值,从0开始,依次递增.
    private enum Seasons{
        spring,winter,summer, fall
    }
    public static void main(String[] args){
        for(Seasons ss: Seasons.values()){
            System.out.println(ss);//结果 spring,winter,summer, fall
        }
    }

    public enum Color {
        RED, GREEN, BLANK, YELLOW
    }

    enum Signal {
        GREEN, YELLOW, RED
    }
    class TrafficLight{
        Signal color = Signal.RED;
        public void change() {
            switch (color) {
                case RED:
                    color = Signal.GREEN;
                    break;
                case YELLOW:
                    color = Signal.RED;
                    break;
                case GREEN:
                    color = Signal.YELLOW;
                    break;
            }
        }
    }

}

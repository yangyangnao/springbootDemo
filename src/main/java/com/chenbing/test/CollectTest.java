package com.chenbing.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectTest {


    public static void main(String[] args) {
        /**
         * 集合类 for
         */
        Collection<User> userCollection = new ArrayList<>();
        for(User user : userCollection){
            System.out.println(user.name);
        }


        /**
         * 集合类 迭代器
         */
        Iterator it = userCollection.iterator();
        while (it.hasNext()){
            System.out.println( it.next());
        }


    }

    class User{
        private Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

package com.faramarz.spring.springcore.unittest;


public class MyMath {


    public int sum(int[] numbers) {
        int first = 0;
        for (int a : numbers) {
            first +=a;

        }
        return first;
    }

}

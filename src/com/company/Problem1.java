package com.company;

import java.util.HashSet;

public class Problem1 {

    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int i = 3; i<= 999; i+=3){
            numbers.add(i);
        }
        for(int i = 5; i<= 995; i+=5){
            numbers.add(i);
        }
        int value =0;
        for(int i : numbers){
            value += i;
        }
        System.out.println(value);
    }
}

package com.company;

import java.util.HashSet;

public class Problem2 {

    public static void main(String[] args) {
        int num = 0;
        HashSet<Integer> evenNumbers = new HashSet<>();
        int last =1;
        int secondLast =0;
        while(num < 4000000){
            num = last + secondLast;
            secondLast = last;
            last = num;
            if(num % 2 ==0){
                evenNumbers.add(num);
            }
        }
        int sum =0;
        for(Integer i:evenNumbers){
            sum += i;
        }
        System.out.println(sum);
    }
}

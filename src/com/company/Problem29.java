package com.company;

import java.util.HashSet;

public class Problem29 {

    public static void main(String... args){
        Problem29 p = new Problem29();
        System.out.println(p.solution(100,100));
    }

    public int solution(int a,int b){
        HashSet<Double> nums = new HashSet<>();
        for(int i = 2; i<=a;i++){
            for(int ii = 2; ii<=b;ii++){
                nums.add(Math.pow(i,ii));
            }
        }
        return nums.size();
    }

}

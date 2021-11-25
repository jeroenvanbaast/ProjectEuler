package com.company;

import java.util.HashSet;

public class Problem44 {

    public static void main(String[] args) {
        Problem44 p = new Problem44();
        p.solution();
    }

    public void solution(){
        HashSet<Integer> h = new HashSet<>();
        for(int i = 1; i< 10000; i++){
            h.add(i*(3*i-1)/2);
        }
        int d = 9999999;
        for(Integer i: h){
            for(Integer j: h){
                if(h.contains(i+j) && h.contains(j-i)){
                    System.out.println(i + " " + j);
                    d = Math.min(d, j-i);
                }
            }
        }
        System.out.println("Solution: " +d);
    }
}

package com.company;

import java.math.BigInteger;

public class Problem63 {

    public static void main(String[] args) {
        Problem63 p = new Problem63();
        p.solution();
    }

    private void solution() {
        int count =0;
        for(int i =1; i< 100;i++){
            for(int j =1; j<100;j++){
                String a = String.valueOf(BigInteger.valueOf(i).pow(j));
                if(a.length() == j){
                    System.out.println(i + " " + j + " = " + a);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
//1037101
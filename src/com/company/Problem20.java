package com.company;

import java.math.BigDecimal;

public class Problem20 {

    public static void main(String... args){
        BigDecimal k = BigDecimal.ONE;
        for(long i =1; i<=100;i++){
            k = k.multiply(BigDecimal.valueOf(i));
        }
        System.out.println(k);
        long n =0;
        for(char c: k.toString().toCharArray()){
            n+= Integer.parseInt(""+c);
        }
        System.out.println(n);
    }
}

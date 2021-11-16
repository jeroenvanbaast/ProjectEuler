package com.company;

import java.math.BigInteger;

public class Problem16 {

    public static void main(String... args) {
        Problem16 p = new Problem16();
        p.solution(new BigInteger("2").pow(1000));
    }

    public long solution(BigInteger input) {
        String v = input.toString();
        long sum = 0;
        for(char c : v.toCharArray()){
            sum += Long.parseLong(String.valueOf(c));
            System.out.println(sum);
        }
        return sum;
    }
}

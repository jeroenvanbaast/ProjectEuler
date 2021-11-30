package com.company;

import java.math.BigInteger;

public class Problem57 {

    public static void main(String[] args) {
        Problem57 p = new Problem57();
        p.solution();
    }

    private void solution() {
        BigInteger numerator = BigInteger.valueOf(7);
        BigInteger denominator = BigInteger.valueOf(5);
        BigInteger a = BigInteger.valueOf(2);
        BigInteger b = BigInteger.valueOf(3);
        long count =0;
        for (int i = 1; i < 999; i++) {
            BigInteger nDenom = denominator.multiply(BigInteger.valueOf(2)).add(a);
            a = denominator;
            denominator = nDenom;

            BigInteger nNum = numerator.multiply(BigInteger.valueOf(2)).add(b);
            b = numerator;
            numerator = nNum;
            if(check(numerator,denominator)){
                count++;
            }
        }
        System.out.println("Solution: " + count);

    }

    private boolean check(BigInteger numerator, BigInteger denominator) {
        String a = String.valueOf(numerator);
        String b = String.valueOf(denominator);
        return a.length() > b.length();
    }
}

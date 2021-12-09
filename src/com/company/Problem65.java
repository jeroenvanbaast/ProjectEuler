package com.company;

import java.math.BigInteger;

public class Problem65 {

    public static void main(String[] args) {
        Problem65 p = new Problem65();
        p.solution(100);
    }

    private void solution(int n) {
        BigInteger e = BigInteger.valueOf(8L);
        BigInteger prevE = BigInteger.valueOf(3);
        int times = 4;
        for (int i = 1; i < n-2; i++) {
            BigInteger tmp = e;
            if (i % 3 == 0) {
                e = e.multiply(BigInteger.valueOf(times)).add(prevE);
                prevE = tmp;
                times += 2;
            } else {
                e = e.add(prevE);
                prevE = tmp;
            }
        }
        System.out.println("Solution: " +
                e.toString().chars().map(c -> Integer.parseInt(String.valueOf((char) c))).sum());
    }
}

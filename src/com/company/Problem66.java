package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem66 {
    public static void main(String[] args) {
        Problem66 p = new Problem66();
        p.solution(1000);
    }

    private void solution(int n) {
        BigInteger maxH = BigInteger.ZERO;
        int solution = 0;
        for (int i = 2; i <= n; i++) {
            BigInteger h = BigInteger.ONE;
            BigInteger hPrev = BigInteger.ZERO;
            BigInteger k = BigInteger.ZERO;
            BigInteger kPrev = BigInteger.ONE;
            if (!needToChek(i)) {
                List<Integer> aValues = calc(i);
                boolean first = true;
                wLoop:
                while (true) {
                    for (Integer a : aValues) {
                        BigInteger tmpH = h.multiply(BigInteger.valueOf(a)).add(hPrev);
                        hPrev = h;
                        h = tmpH;

                        BigInteger tmpK = k.multiply(BigInteger.valueOf(a)).add(kPrev);
                        kPrev = k;
                        k = tmpK;
                        if (h.pow(2).subtract(BigInteger.valueOf(i).multiply(k.pow(2))).equals(BigInteger.ONE)) {
                            break wLoop;
                        }
                    }
                    if (first) {
                        aValues.remove(0);
                        first = false;
                    }
                }
                if (!h.pow(2).subtract(BigInteger.valueOf(i).multiply(k.pow(2))).equals(BigInteger.ONE)) {
                    System.out.println("Fold in: " + i + "= " + h + "/" + k + " = " + h.pow(2).subtract(BigInteger.valueOf(i).multiply(k.pow(2))));
                }
                if (h.compareTo(maxH) > 0) {
                    maxH = h;
                    solution = i;
                }
            }
        }
        System.out.println("Solution: " + solution);
    }

    private List<Integer> calc(int i) {
        List<Integer> aValues = new ArrayList<>();
        int d = 1;
        int m = 0;
        int a = (int) Math.sqrt(i);
        int a0 = (int) Math.sqrt(i);
        aValues.add(a0);
        while (a0 * 2 != a) {
            m = d * a - m;
            d = (i - (m * m)) / d;
            a = (a0 + m) / d;
            aValues.add(a);
        }
        return aValues;
    }

    private boolean needToChek(int i) {
        int d = (int) Math.sqrt(i);
        double d2 = Math.sqrt(i);
        return d == d2;
    }
}

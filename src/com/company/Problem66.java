package com.company;

import java.math.BigDecimal;
import java.math.MathContext;

public class Problem66 {
    public static void main(String[] args) {
        Problem66 p = new Problem66();
        p.solution(1000);
    }

    private void solution(int k) {
        BigDecimal maxX = BigDecimal.ZERO;
        long solution = 0L;
        for (long d = 1; d <= k; d++) {
            if (!needToChek(d)) {
                System.out.println(d);
                BigDecimal y = BigDecimal.ONE;
                while (true) {
                    BigDecimal x = BigDecimal.valueOf(d).multiply(y.pow(2)).add(BigDecimal.ONE).sqrt(new MathContext(3));
                    if (x.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                        if(!x.pow(2).subtract(BigDecimal.valueOf(d).multiply(y.pow(2))).equals(BigDecimal.ONE)){
                            y = y.add(BigDecimal.ONE);
                            continue;
                        }
                        if(x.compareTo(maxX) > 0){
                            maxX = x;
                            solution = d;
                        }
//                        System.out.println(" d: " + d + " x: " + x + " y: " + y);
                        break;
                    }y = y.add(BigDecimal.ONE);
                }
            }
        }
        System.out.println("Solution: " + solution);
    }

    private boolean needToChek(long i) {
        int d = (int) Math.sqrt(i);
        double d2 = Math.sqrt(i);
        return d == d2;
    }
}

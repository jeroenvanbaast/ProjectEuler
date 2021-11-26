package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem53 {

    public static void main(String[] args) {
        Problem53 p = new Problem53();
        p.solution();
    }

    private void solution() {
        int count =0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                BigInteger a = factorial(BigInteger.valueOf(n));
                BigInteger b = factorial(BigInteger.valueOf(r));
                if(a.divide(b.multiply(factorial(BigInteger.valueOf(n - r)))).compareTo(BigInteger.valueOf(1_000_000)) > 0){
                    count++;
                } 
            }
        }
        System.out.println("Solution: " + count);
    }

    static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) )
            return BigInteger.ONE;
        else
            return (n.multiply(factorial(n.subtract(BigInteger.ONE))));
    }
}

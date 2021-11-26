package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem53 {

    public static void main(String[] args) {
        Problem53 p = new Problem53();
        p.solution();
    }

    private void solution() {
        BigInteger[] fac = new BigInteger[101];
        for(int i = 0; i<=100;i++){
            fac[i] = factorial(BigInteger.valueOf(i));
        }
        int count =0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if(fac[n].divide(fac[r].multiply(fac[n-r])).compareTo(BigInteger.valueOf(1_000_000)) > 0){
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

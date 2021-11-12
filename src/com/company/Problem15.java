package com.company;

import java.math.BigInteger;

public class Problem15 {

    public static void main(String... args){
        System.out.println(binomial(40, 20));
    }

    // n choose k
    static BigInteger binomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }


}

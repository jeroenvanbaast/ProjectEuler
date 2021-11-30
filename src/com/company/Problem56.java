package com.company;

import java.math.BigInteger;

public class Problem56 {

    public static void main(String[] args) {
        Problem56 p = new Problem56();
        p.solution();
    }

    private void solution() {
        BigInteger h = BigInteger.ZERO;
        for(int i = 0; i<100;i++){
            for(int j=0; j<100;j++){
                BigInteger tmp = digitCount(BigInteger.valueOf(i).pow(j));
                h = tmp.max(h);
            }
        }
        System.out.println("Solution: " + h);
    }

    public BigInteger digitCount(BigInteger a){
        String b = a.toString();
        BigInteger sum = BigInteger.ZERO;
        for(char c : b.toCharArray()){
            sum = sum.add(new BigInteger(""+c));
        }
        return sum;
    }
}

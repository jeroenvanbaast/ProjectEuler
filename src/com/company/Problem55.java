package com.company;

import java.math.BigInteger;

public class Problem55 {

    public static void main(String[] args) {
        Problem55 p = new Problem55();
        p.solution();
    }

    private void solution() {
        int count =0;
        for(int i = 1; i< 10_000; i++){
            if(!check(i)){
                count++;
            }
        }
        System.out.println("Solution: " + count);
    }

    public boolean check(int a){
        int count =0;
        BigInteger b = BigInteger.valueOf(a);
        for(int i =0; i<=50;i++){
            b = b.add(reverse(b));
            count++;
            if(isPalindromic(b)){
                System.out.println(a + " " + count);
                return true;
            }
        }
        return false;
    }

    public BigInteger reverse(BigInteger a){
        StringBuilder sb = new StringBuilder(String.valueOf(a)).reverse();
        return new BigInteger(sb.toString());
    }

    public boolean isPalindromic(BigInteger a){
        String b = String.valueOf(a);
        int i = 0;
        int j = b.length()-1;
        while(i < j){
            if(b.charAt(i++) != b.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}

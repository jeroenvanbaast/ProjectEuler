package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Problem48 {

    public static void main(String[] args) {
        Problem48 p = new Problem48();
        long start = new Date().getTime();
        p.solution();
        System.out.println(new Date().getTime()-start);
    }

    public void solution(){
        long ans = 0;
        for(int i = 1; i < 1000; i++){
            ans += getLast10(BigInteger.valueOf(i).pow(i));
            ans = getLast10(BigInteger.valueOf(ans));
        }
        System.out.println(ans);
    }

    public long getLast10(BigInteger n){
        String b = n.toString();
        return b.length() > 10 ? Long.parseLong(b.substring(b.length()-10)) : Long.parseLong(b);
    }
}

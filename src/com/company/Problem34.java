package com.company;

import java.math.BigDecimal;

public class Problem34 {

    public static void main(String... args) {
        Problem34 p = new Problem34();
        p.solution();
    }

    public void solution() {
        int a = 0;
        for (long i = 3; i < 1_000_000; i++) {
            if(isDigitFactorial(i)){
                System.out.println(i);
                a+=i;
            }
        }
        System.out.println("Solution: " + a);
    }

    public boolean isDigitFactorial(long i){
        long a =0;
        for(char c: String.valueOf(i).toCharArray()){
            a+= factorial(Integer.valueOf(""+c));
        }
        return a==i;
    }

    public Integer factorial(int j) {
        int ans = 1;
        for (int i = 2; i <= j; i++) {
            ans *=i;
        }
        return ans;
    }
}

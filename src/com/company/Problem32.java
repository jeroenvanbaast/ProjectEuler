package com.company;

import java.math.BigDecimal;
import java.util.HashSet;

public class Problem32 {

    public static void main(String... args) {
        Problem32 p = new Problem32();
        p.solution();
    }

    public void solution() {
        HashSet<Integer> test = new HashSet<>();
        BigDecimal sum = BigDecimal.ZERO;
        int count = 0;
        for (int i = 1; i < 10_000; i++) {
            for (int j = 1; j < 100_000; j++) {
                int t = i * j;
                if (isPandigital(""+t+i+j)) {
                    if (test.add(t)) {
                        sum = sum.add(BigDecimal.valueOf(t));
                        count++;
                    }
                }
                if(t> 9_876_543){
                    break;
                }
            }
        }
        System.out.println("Solution: " + sum);
    }

    public boolean isPandigital(String n) {
        if(n.length() != 9){
            return false;
        }
        HashSet<String> test = new HashSet<>();
        test.add("0");
        for (char c : n.toCharArray()) {
            if(!test.add("" + c)){
                return false;
            }
        }
        return test.size() == 10;
    }
}

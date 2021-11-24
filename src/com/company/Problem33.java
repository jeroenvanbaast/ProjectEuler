package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Problem33 {

    ArrayList<Integer> count = new ArrayList<>();
    public static void main(String... args) {
        Problem33 p = new Problem33();
//        p.isInteresting(16, 64);
        p.solution();
    }

    public void solution() {
        int ans = 1;
        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                if (isInteresting(i, j)) {
                    int t = getDenominator(Double.valueOf(j)/ Double.valueOf(i));
                    System.out.println(i + " " + j + " " + t);
                    ans *= t;
                }
            }
        }
        System.out.println(ans/2);
    }

    public boolean isInteresting(int aa, int bb) {
        int a = Integer.parseInt(String.valueOf(aa).substring(0, 1));
        int a2 = Integer.parseInt(String.valueOf(aa).substring(1));
        int b = Integer.parseInt(String.valueOf(bb).substring(0, 1));
        int b2 = Integer.parseInt(String.valueOf(bb).substring(1));
        if (a == a2 && b == b2) {
            return false;
        }
        BigDecimal t = BigDecimal.valueOf(aa).divide(BigDecimal.valueOf(bb), 500, RoundingMode.HALF_UP);
        if (b2 == a && a2 != 0) {
            BigDecimal t3 = BigDecimal.valueOf(a2).divide(BigDecimal.valueOf(b), 500, RoundingMode.HALF_UP);
            if (t3.equals(t)) {
                return true;
            }
        }
        if (a2 == b && b2 != 0) {
            BigDecimal t4 = BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b2), 500, RoundingMode.HALF_UP);
            if (t4.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public int getDenominator(Double d){
        if(d%1 ==0){
            return d.intValue();
        }
       return getDenominator(d*2);
    }
}

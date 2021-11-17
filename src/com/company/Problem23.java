package com.company;

import java.util.ArrayList;

public class Problem23 {

    public static void main(String... args) {
        Problem23 p = new Problem23();
        int limit = 28123;
        boolean[] test = new boolean[limit];
        ArrayList<Integer> abundants = new ArrayList<>();
        for (int i = 0; i < limit - 12; i++) {
            if (p.isAbundant(i)) {
                abundants.add(i);
            }
        }
        for (int i = 0; i < abundants.size() - 1; i++) {
            for (int ii = i; ii < abundants.size(); ii++) {
                int k = abundants.get(i) + abundants.get(ii);
                if (k < test.length) {
                    test[abundants.get(i) + abundants.get(ii)] = true;
                }else{break;}
            }
        }
        long sum = 0L;
        for (int i = 0; i < limit; i++) {
            if (!test[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public Boolean isAbundant(int a) {
        int sum = 0;
        for (int i = 1; i < a / 2 + 1; i++) {
            if (a % i == 0) {
                sum += i;
            }
        }
        if (sum > a) {
            return true;
        }
        return false;
    }
}

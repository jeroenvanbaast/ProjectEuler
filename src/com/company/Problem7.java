package com.company;

import java.util.ArrayList;

public class Problem7 {

    public static void main(String... arg) {
        var a = primeNumbers(10001);
        System.out.println(a.get(a.size()-1));
    }

    static ArrayList<Integer> primeNumbers(int n) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int i = 1;
        while (primeNumbers.size() != n) {
            int counter = 0;
            for (int num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                primeNumbers.add(i);
            }
            i++;
        }
        return primeNumbers;
    }
}

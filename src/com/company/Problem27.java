package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Problem27 {

    // n^n + n * a + b
    // a < 1000, b =< 1000, n > 0
    public static void main(String... args) {
        Problem27 p = new Problem27();
        System.out.println(p.count());
    }

    public int count() {
        int count = 0;
        int h = 0;
        int ans = 0;
        for (int a = -1000; a < 1000; a++) {
            for (int b = -1000; b < 1000; b++) {
                int n = 0;
                while (isPrime(n * n + a * n + b)) {
                    count++;
                    n++;
                }
                if (count > h) {
                    h = count;
                    ans = a * b;
                }
                h = Math.max(count, h);
                count = 0;
            }
        }
        return ans;
    }

    public boolean isPrime(long d) {
        if (d <= 1) {
            return false;
        }
        if (d == 2) {
            return true;
        }
        for (int i = 2; i < d - 1; i++) {
            if (d % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void practice(int n) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int t = (i * i) + i + 41;
            if (isPrime(t)) {
                answer++;
            }
            System.out.println(t + " " + isPrime(t));
        }
        System.out.println("Solution: " + answer);
    }
}

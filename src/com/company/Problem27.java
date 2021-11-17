package com.company;

public class Problem27 {

    // n^n + n * a + b
    // a < 1000, b =< 1000, n > 0
    public static void main(String... args) {
        Problem27 p = new Problem27();
        p.tryForN(50);
    }

    public void tryForN(int t) {
        int h = 0;
        int answer = 0;
        for (int i = 0; i < t; i++) {
            System.out.println(i);
            for (int a = 1; a < 1000; a++) {
                for (int b = 1; b <= 1000; b++) {
                    int count = 0;
                    long o = test(a, b, i);
                    if (isPrime(o)) {
                        count++;
                    } else {
                        if (h < count) {
                            answer = a * b;
                            h = count;
                        }
                        count = 0;
                    }
                }
            }
        }
        System.out.println("Solution: " + answer);
    }

    public long test(int a, int b, int n) {
        return (long) (Math.pow(n, 2) + n * a + b);
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
}

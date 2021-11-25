package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem46 {

    public static void main(String[] args) {
        Problem46 p = new Problem46();
        System.out.println();
        p.solution();
    }

    public void solution() {
        ArrayList<Integer> primes = primes(6_000);
        out:
        for (int i = 1187; i < 6000; i += 2) {
            if (primes.contains(i)) {
                continue;
            }
            for (Integer a : primes) {
                for (int b = 1; b < i; b++) {
                    int n = a + 2 * (b * b);
                    if (n > i) {
                        break;
                    }
                    if (i == n) {
                        continue out;
                    }
                }
            }
            System.out.println("Solution: " + i);
            break;
        }
    }

    public ArrayList<Integer> primes(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) {
                continue;
            }
            if (!isPrime(i)) {
                for (int j = i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(1);
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
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

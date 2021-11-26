package com.company;

import java.util.ArrayList;

public class Problem49 {

    public static void main(String[] args) {
        Problem49 p = new Problem49();
        p.solution();
    }

    public void solution() {
        findPermutations(get4DigitPrimes());
    }

    public void findPermutations(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size() - 1; k++) {
                    int a = list.get(i);
                    int b = list.get(j);
                    int c = list.get(k);
                    if (a+3330 == b && b+3330 == c) {
                        if (isPermutation(a, b) && isPermutation(a, c)) {
                            System.out.println(a + " " + b + " " + c);
                        }
                    }
                }
            }
        }
    }

    public boolean isPermutation(Integer a, Integer b) {
        char[] bchars = String.valueOf(b).toCharArray();
        out:
        for (char c : String.valueOf(a).toCharArray()) {
            for (int i = 0; i < bchars.length; i++) {
                if (c == bchars[i]) {
                    bchars[i] = 'a';
                    continue out;
                }
            }
            return false;
        }
        return true;
    }

    public ArrayList<Integer> get4DigitPrimes() {
        int n = 9999;
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
        for (int i = 1000; i < notPrime.length; i++) {
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

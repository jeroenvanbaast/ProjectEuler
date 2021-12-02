package com.company;

import java.util.ArrayList;

public class Problem51 {

    ArrayList<String> wildcards = new ArrayList<>();

    public static void main(String[] args) {
        Problem51 p = new Problem51();
        p.solutions();
    }

    private void solutions() {
        ArrayList<Integer> primes = primes(1_000_000);
        for (Integer prime : primes) {
            String p = String.valueOf(prime);
            generateNumber(p, 0);

        }
        for (String s : wildcards) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                String v = s.replaceAll("[*]", String.valueOf(i));
                if (v.startsWith("0")) {
                    continue;
                }
                int n = Integer.parseInt(v);
                if (primes.contains(n)) {
                    count++;
                }
            }
            if (count >= 8) {
                for (int i = 0; i < 10; i++) {
                    String v = s.replaceAll("[*]", String.valueOf(i));
                    System.out.println(v);
                }
                return;
            }
        }

    }

    private void generateNumber(String s, int index) {
        if (index > 1) {
            wildcards.add(s);
        }
        for (int i = index; i < s.length(); i++) {
            generateNumber(replaceChar(s, i), i + 1);
        }
    }

    private String replaceChar(String s, int i) {
        return s.substring(0, i) + "*" + s.substring(i + 1);
    }

    public ArrayList<Integer> primes(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) {
                continue;
            }
            for (int j = i + i; j < n; j += i) {
                notPrime[j] = true;
            }

        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }


}

package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Problem35 {

    public static void main(String[] args) {
        Problem35 p = new Problem35();
        p.solution();
    }

    public void solution() {
        findPrimes(1_000_000);
    }

    public void findPrimes(int n) {
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
        HashSet<Integer> primes = new HashSet<>();
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }
        int count = 0;
        for (Integer prime : primes) {
            if (isCircular(prime, primes)) {
                System.out.println(prime);
                count++;
            }
        }
        System.out.println("Solution: " + count);
    }

    public boolean isCircular(int j, HashSet<Integer> primes) {
        String s = String.valueOf(j);
        String a = s;
        while(true){
            char tmp = a.charAt(0);
            a= a.substring(1)+tmp;
            if(!isPrime(Integer.valueOf(a))){
                return false;
            }
            if(a.equals(s)){
                return true;
            }
        }
    }

    public boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

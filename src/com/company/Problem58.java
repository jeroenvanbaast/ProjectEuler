package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem58 {

    public static void main(String[] args) {
        Problem58 p = new Problem58();
        p.solution();
    }

    private void solution() {
        HashSet<Integer> primes = primes(800_000_000);
        int length = 4;
        double primesCount = 3;
        double nonPrimesCount = 2;
        int k = 9;
        while(100/(primesCount+nonPrimesCount) * primesCount > 10){
            for(int i = 0; i<4;i++){
                k += length;
                if(primes.add(k)){
                    nonPrimesCount++;
                }else{
                    primesCount++;
                }
            }
            length+=2;
        }
        System.out.println("Solution: " + (length-1));
    }

    public HashSet<Integer> primes(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) {
                continue;
            }
            for (int j = i + i; j < n; j += i) {
                notPrime[j] = true;
            }

        }
        HashSet<Integer> primes = new HashSet<>();
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}

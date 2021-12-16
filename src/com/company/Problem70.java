package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem70 {
    ArrayList<Integer> primes = primes(10_000_000);

    public static void main(String[] args) {
        Problem70 p = new Problem70();
        p.solution();
    }

    private void solution() {
        Double lowest = 100.0;
        for(int i =2; i < 10_000_000; i++){
            if(!primes.contains(i)){
                continue;
            }
            double a = relativePrimes(i);
            if(isPermutation(a,i)){
                if(lowest > i/a){
                    System.out.println(i + " " + a + " " + (i/a));
                    lowest = i/a;
                }
            }
        }
    }

    public boolean isPermutation(Double a, Integer b) {
        String x = String.valueOf(a);
        String y = String.valueOf((double) b);
        char[] bchars = x.toCharArray();
        out:
        for (char c : y.toCharArray()) {
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

    private Double relativePrimes(int n) {
        List<Integer> toReturn = new ArrayList<>();
        HashSet<Integer> toTest = new HashSet<>();
        for(int i =2; i < n; i++){
            if(n%i ==0){
                toTest.add(i);
            }
        }
        outer: for(int i =1; i<n;i++){
            for(int t : toTest){
                if(i%t == 0){
                    continue outer;
                }
            }
            toReturn.add(i);
        }
        return (double) toReturn.size();
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

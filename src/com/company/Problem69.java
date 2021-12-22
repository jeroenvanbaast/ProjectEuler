package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem69 {

    public static void main(String[] args) {
        Problem69 problem69 = new Problem69();
        problem69.betterSolution(1_000_000);
        problem69.solution(1_000_000);
    }

    private void betterSolution(int limit){
        int ans =1;
        ArrayList<Integer> primes = primes(100);
        int i =0;
        while(true){
            ans*= primes.get(i);
            if(ans > limit){
                System.out.println("Solution: " + (ans/primes.get(i)));
                return;
            }
            i++;
        }
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

    private void solution(int maxN) {
        double h = 0;
        int hN = 0;
        int t = 1;
        for (int n = 2; n <= maxN; n+=t) {
            double tmp = n / relativePrimes(n);
            if (tmp > h) {
//                System.out.println(n);
                h = tmp;
                hN = n;
                t = n;
            }
        }
        System.out.println("Solution: " + hN);
    }

    private double relativePrimes(int n) {
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
        return toReturn.size();
    }

}

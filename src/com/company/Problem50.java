package com.company;

import java.util.ArrayList;

public class Problem50 {

    public static void main(String[] args) {
        Problem50 p = new Problem50();
        p.solution();
    }

    private void solution() {
        ArrayList<Integer> primes = primes(1_000_000);
        int highestPrime = primes.get(primes.size() - 1);
        int size = 3;
        int a = 0;
        while (size < primes.size()) {
            for (int i = 0; i < primes.size() - size; i++) {
                int sum = 0;
                for (int j = 0; j < size; j++) {
                    sum += primes.get(i + j);
                }
                if (sum > highestPrime) {
                    if(i==0){
                        System.out.println(a);
                        return;
                    }
                    size++;
                    break;
                } else if (primes.contains(sum)) {
                    a = sum;
                    size++;
                    break;
                }
            }
        }
        System.out.println(a);
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

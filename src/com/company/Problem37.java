package com.company;

import java.util.HashSet;

public class Problem37 {

    public static void main(String[] args) {
        Problem37 p = new Problem37();
        p.solution();
    }

    // 23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397
    public void solution() {
        findPrimes(10_000_000);
    }


    public boolean isTruncatable(int a) {
        String b = String.valueOf(a);
        while (b.length() != 1) {
            b = b.substring(1);
            if (!isPrime(Integer.parseInt(b))) {
                return false;
            }
        }
        b = String.valueOf(a);
        while (b.length() != 1) {
            b = b.substring(0, b.length() - 1);
            if (!isPrime(Integer.parseInt(b))) {
                return false;
            }
        }
        return true;
    }

    public void findPrimes(int n) {
        int count = 0;
        int sum = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 10; i < n; i++) {
            if (notPrime[i]) {
                continue;
            }
            if (!isPrime(i)) {
                for (int j = i; j < n; j += i) {
                    notPrime[j] = true;
                }
            } else {
                if (isTruncatable(i)) {
                    count++;
                    sum += i;
                    System.out.println(count + " " + i);
                }
            }
        }
        System.out.println("Solution: " + sum);
    }

    public boolean isPrime(int number) {
        if(number == 1){
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

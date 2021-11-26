package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class Problem47 {

    public static void main(String[] args) {
        Problem47 p = new Problem47();
        p.solution();
    }

    public void solution() {
        ArrayList<Integer> primes = primes(1000);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(0);
        ans.add(0);
        int a = 0;
        out:
        for (int i = 644; i < 100_000_000; i++) {
            a = i;
            int j = 2;
            HashSet<Integer> set = new HashSet<>();
            while (true) {
                if (a % j == 0) {
                    set.add(j);
                    a = a / j;
                } else if (j > a) {
                    break;
                } else {
                    j++;
                }
            }
            for (Integer h : set) {
                if (!primes.contains(h)) {
                    continue out;
                }
            }
            if (set.size() == 4) {
                ans.add(i);
                int index = ans.indexOf(i);
                if (ans.get(index - 3) + 1 == ans.get(index - 2) && ans.get(index - 2) + 1 == ans.get(index - 1) && ans.get(index - 1) + 1 == i) {
//                    System.out.println(ans.get(index - 3)  + " " + ans.get(index - 2) + " " + ans.get(index - 1) + " " + i);
                    System.out.println("solution: " +ans.get(index - 3) );
                    return;
                }
            }
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
}

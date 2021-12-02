package com.company;

import java.awt.*;
import java.util.*;

public class Problem60 {

    ArrayList<Integer> primes = primes(100_000_000);

    public static void main(String[] args) {
        Problem60 p = new Problem60();
        p.betterSolution();
    }

    public void betterSolution() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer p : primes(100_000)) {
            String a = String.valueOf(p);
            for (int i = 1; i < a.length(); i++) {
                int x = Integer.parseInt(a.substring(0, i));
                int y = Integer.parseInt(a.substring(i));
                if (primes.contains(x) && primes.contains(y) && primes.contains(Integer.parseInt("" + y + x))) {
                    for (Integer z : list) {
                        if (primes.contains(Integer.parseInt("" + y + z)) && primes.contains(Integer.parseInt("" + z + y))
                                && primes.contains(Integer.parseInt("" + x + z)) && primes.contains(Integer.parseInt("" + z + x))) {
                            for (Integer o : list) {
                                if (primes.contains(Integer.parseInt("" + y + o)) && primes.contains(Integer.parseInt("" + x + o))
                                        && primes.contains(Integer.parseInt("" + z + o)) && primes.contains(Integer.parseInt("" + o + x))
                                        && primes.contains(Integer.parseInt("" + o + y)) && primes.contains(Integer.parseInt("" + o + z))) {
                                    for (Integer k : list) {
                                        if (primes.contains(Integer.parseInt("" + y + k)) && primes.contains(Integer.parseInt("" + x + k))
                                                && primes.contains(Integer.parseInt("" + z + k)) && primes.contains(Integer.parseInt("" + k + x))
                                                && primes.contains(Integer.parseInt("" + k + y)) && primes.contains(Integer.parseInt("" + k + z))
                                                && primes.contains(Integer.parseInt("" + k + o)) && primes.contains(Integer.parseInt("" + o + k)))
                                            System.out.println(x + " " + y + " " + z + " " + o + " " + k);
                                    }
                                }
                            }
                        }
                    }
                    if (!list.contains(x)) {
                        list.add(x);
                    }
                    if (!list.contains(y)) {
                        list.add(y);
                    }
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
        for (int i = 3; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}

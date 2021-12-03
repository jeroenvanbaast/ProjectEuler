package com.company;

import java.util.*;

public class Problem60 {

    HashSet<Integer> primes = primes(100_000_000);

    public static void main(String[] args) {
        Problem60 p = new Problem60();
        p.check(new int[]{8389, 6733, 5701, 13, 5197});
        p.betterSolution();
    }

    public void betterSolution() {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> ps = primes(10_000);
        for (Integer x : ps) {
            for (Integer y : ps) {
                if (x == y) {
                    continue;
                }
                Integer a = Integer.parseInt("" + x + y);
                Integer b = Integer.parseInt("" + y + x);
                if (primes.contains(a) && primes.contains(b)) {
                    if (!map.containsKey(x)) {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(y);
                        map.put(x, set);
                    } else {
                        map.get(x).add(y);
                    }
                    if (!map.containsKey(y)) {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(x);
                        map.put(y, set);
                    } else {
                        map.get(y).add(x);
                    }
                }
            }
        }
        for (Map.Entry<Integer, HashSet<Integer>> e : map.entrySet()) {
            if (e.getValue().size() >= 4) {
                if (e.getKey() < 673) {
                    continue;
                }
                for (Integer i : e.getValue()) {
                    ArrayList<Integer> toTest = new ArrayList<>();
                    for (Integer j : e.getValue()) {
                        if (map.get(i).contains(j)) {
                            toTest.add(j);
                        }
                    }
                    if (toTest.size() > 2) {
                        for (int k = 0; k < toTest.size(); k++) {
                            for (int m = k + 1; m < toTest.size(); m++) {
                                for (int n = m + 1; n < toTest.size(); n++) {
                                    if (check(new int[]{i, e.getKey(), toTest.get(k), toTest.get(m), toTest.get(n)})) {
                                        System.out.println(i + " " + e.getKey() + " " + toTest.get(k) + " " + toTest.get(m) + " " + toTest.get(n) + "  Sum: " + (i + e.getKey() + toTest.get(k) + toTest.get(m) + toTest.get(n)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean check(int[] a) {
        for (Integer i : a) {
            for (int j : a) {
                if (i == j) {
                    continue;
                }
                Integer c = Integer.parseInt("" + i + j);
                if (!primes.contains(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public HashSet<Integer> primes(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) {
                continue;
            }
            for (int j = i + i; j < n && j > 0; j += i) {
                notPrime[j] = true;
            }

        }
        HashSet<Integer> primes = new HashSet<>();
        for (int i = 3; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}

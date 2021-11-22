package com.company;

import java.util.Arrays;

public class Problem28 {

    public static void main(String... args) {
        Problem28 p = new Problem28();
        p.build(1002001);
    }

    public void build(int a) {
        int t = (int) Math.sqrt(a);
        int[][] f = new int[t][t];
        int h = t / 2;
        int v = t / 2;
        for (int i = 1; i <= a; i++) {
            f[v][h] = i;
            if (v > h && f[v - 1][h] == 0) {
                v--;
            } else if (h > v && v < t / 2 && f[v + 1][h] != 0) {
                h++;
            } else if (h > v) {
                v++;
            } else if (h == v && h <= t / 2) {
                h++;
            } else if (h == v) {
                h--;
            } else if (v > h) {
                h--;
            }
        }
        print(f);
    }

    public static void print(int[][] f) {
        int sum = 0;
        int i = 0;
        for (int[] t : f) {
            int a = t[i];
            int b = t[t.length - ++i];
            sum += a + b;
            System.out.println(Arrays.toString(t));
        }
        System.out.println("Solution: " + (sum-1));
    }
}

package com.company;

import java.util.ArrayList;

public class Problem9 {

    public static void main(String... args) {
        int[] t = findPythagoreanTriplet(1000);
        System.out.println(t[0] * t[1] * t[2]);
    }

    public static int[] findPythagoreanTriplet(int x) {
        ArrayList<Integer> nums = getNumbersTill(10000);
        for (Integer i : nums) {
            for (Integer ii : nums) {
                if(i> ii){
                    continue;
                }
                int k = (int) Math.sqrt(i * i + ii * ii);
                if (i * i + ii * ii == k*k) {
                    System.out.println(i + " " + ii + " " + k + "sum: " + (i+ii+k));
                    if (i + ii + k == x) {
                        return new int[]{i, ii, k};
                    }else if(i + ii + k > x){
                        break;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Argument not a pythagorean triplet");
    }

    public static ArrayList<Integer> getNumbersTill(int max) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            nums.add(i);
        }
        return nums;
    }
}

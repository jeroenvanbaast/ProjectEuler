package com.company;

import java.util.ArrayList;

// TODO: Should be more elegant solution then to bruteforce it.
public class Problem12 {

    public static void main(String... args) {
        Problem12 p12 = new Problem12();
        System.out.println("Answer is:" + p12.getTriangleNumbers(500000, 500));
    }

    public long getTriangleNumbers(int n, int z) {
        ArrayList<Long> triangle = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            long sum = 0;
            for (int s =0; s <i; s++) {
                sum += s;
            }
            triangle.add(sum);
            int count = 0;
            for (int ii = 1; ii < sum; ii++) {
                if (sum % ii == 0) {
                    count++;
                }
            }
            System.out.println(sum + " : " + count);
            if (count >= z) {
                return sum;
            }
        }
        return 0;
    }

}

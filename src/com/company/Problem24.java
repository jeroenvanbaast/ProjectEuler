package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem24 {

    private int count = 0;

    // 012   021   102   120   201   210
    public static void main(String... args) {
        Problem24 p = new Problem24();
//        p.solution(10);
        p.solution();
    }

    //Better
    private void solution() {
        pandigital("", Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    private void pandigital(String pandigital, List<String> toAdd) {
        if (toAdd.isEmpty()) {
            count++;
            if (count == 1_000_000) {
                System.out.println(pandigital);
            }
            return;
        } else {
            for (String add : toAdd) {
                List<String> stillToAdd = new ArrayList<>(toAdd);
                stillToAdd.remove(add);
                pandigital(pandigital + add, stillToAdd);
            }
        }

    }


    // Brute force
    public String solution(int a) {
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int ii = 0; ii < a; ii++) {
                for (int iii = 0; iii < a; iii++) {
                    for (int iiii = 0; iiii < a; iiii++) {
                        for (int iiiii = 0; iiiii < a; iiiii++) {
                            for (int iiiiii = 0; iiiiii < a; iiiiii++) {
                                for (int iiiiiii = 0; iiiiiii < a; iiiiiii++) {
                                    for (int iiiiiiii = 0; iiiiiiii < a; iiiiiiii++) {
                                        for (int iiiiiiiii = 0; iiiiiiiii < a; iiiiiiiii++) {
                                            for (int iiiiiiiiii = 0; iiiiiiiiii < a; iiiiiiiiii++) {
                                                HashSet<Integer> test = new HashSet<Integer>(Arrays.asList(i, ii, iii, iiii, iiiii, iiiiii, iiiiiii, iiiiiiii, iiiiiiiii, iiiiiiiiii));
                                                if (test.size() == 10) {
                                                    count++;
                                                }
                                                if (count == 1_000_000) {
                                                    System.out.println("" + i + ii + iii + iiii + iiiii + iiiiii + iiiiiii + iiiiiiii + iiiiiiiii + iiiiiiiiii);
                                                    System.out.println(count);
                                                    return "";
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
        return "";
    }

}

package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.max;

public class Problem18 {

    String input = "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

//    String input = "3\n" +
//            "7 4\n" +
//            "2 4 6\n" +
//            "8 5 9 3";

    public static void main(String... args) {
        Problem18 p = new Problem18();
        ArrayList<ArrayList<Integer>> tri = p.makeTriangle();
        p.solutionBruteForce(tri);
    }

    private void solutionBruteForce(ArrayList<ArrayList<Integer>> tri) {
        for (int j = 1; j < tri.size(); j++) {
            int i = 0;
            for (Integer n : tri.get(j)) {
                int p1 = 0;
                int p2 = 0;
                if (i != 0) {
                    p1 = tri.get(j-1).get(i - 1);
                }
                if (i != tri.get(j-1).size()) {
                    p2 = tri.get(j-1).get(i);
                }
                int p = max(p1, p2);
                tri.get(j).set(i, n + p);
                i++;
            }
        }
        System.out.println(tri.get(tri.size()-1));
    }



    public ArrayList<ArrayList<Integer>> makeTriangle() {
        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
        for (String s : input.split("\n")) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (String c : s.split(" ")) {
                tmp.add(Integer.valueOf(c));
            }
            toReturn.add(tmp);
        }
        return toReturn;
    }
}

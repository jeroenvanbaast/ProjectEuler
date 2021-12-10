package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem68 {

    ArrayList<String> options = new ArrayList<>();
    int size = 5;

    public static void main(String[] args) {
        Problem68 p = new Problem68();
        p.solution(Arrays.asList(6, 5, 4, 3, 2, 1));
    }

    private void solution(List<Integer> input) {
        test("", input);
        outer:
        for (String s : options) {
            int[][] tmp = doMagic(s);
            int first = tmp[0][0];
            for (int[] ar : tmp) {
                if (ar[0] < first) {
                    continue outer;
                }
            }
            System.out.println(outPut(tmp));
        }
    }

    private Long valueOf(int[][] input) {
        String toReturn = "";
        for (int[] ar : input) {
            for (int i : ar) {
                toReturn += i;
            }
        }
        return Long.parseLong(toReturn);
    }

    private String outPut(int[][] sol) {
        String toReturn = "";
        for (int[] ar : sol) {
            for (int i : ar) {
                toReturn += i + ",";
            }
            toReturn += "; ";
        }
        return toReturn;
    }

    private int[][] doMagic(String s) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i =0; i < s.length(); i++){
            int toAdd = Integer.parseInt(s.substring(i,i+1));
            if(i != s.length()-1 && toAdd ==1 && Integer.parseInt(s.substring(i+1,i+2)) ==0){
                i++;
                toAdd =10;
            }
            tmp.add(toAdd);
        }
        int[][] sol = new int[size][3];
        for (int i = 0; i < size; i++) {
            sol[i][0] = tmp.get(i);
        }
        for (int i = size; i < size * 2; i++) {
            sol[i - size][1] = tmp.get(i);
            if (i == (size * 2) - 1) {
                sol[i - size][2] =tmp.get(size);
            } else {
                sol[i - size][2] = tmp.get(i+1);
            }
        }
        return sol;
    }

    private void test(String s, List<Integer> toPlace) {
        if (toPlace.size() == 0) {
            if (check(s)) {
                options.add(s);
            }
            return;
        }
        for (Integer i : toPlace) {
            List<Integer> tmp = new ArrayList<>(toPlace);
            tmp.remove(i);
            test(s + i, tmp);
        }
    }

    private boolean check(String s) {
        int[][] toCheck = doMagic(s);
        int[] check = new int[toCheck.length];
        for (int i = 0; i < toCheck.length; i++) {
            check[i] = Arrays.stream(toCheck[i]).sum();
        }
        return Arrays.stream(check).filter(a -> a != check[0]).count() == 0;
    }
}

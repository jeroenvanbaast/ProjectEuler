package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem68 {

    int size = 5;

    public static void main(String[] args) {
        Problem68 p = new Problem68();
        p.solution(Arrays.asList(10,9,8,7,6, 5, 4, 3, 2, 1));
    }

    private void solution(List<Integer> input) {
        test("", input);
    }

    private Long valueOf(int[][] input) {
        int lowestI = 0;
        int lowest = 999999;
        for(int i =0; i< input.length; i++){
            if(input[i][0] < lowest){
                lowest = input[i][0];
                lowestI = i;
            }
        }
        int[][] tmp = new int[input.length][input[0].length];
        for(int i =0; i< input.length; i++){
            int newIndex = lowestI+i > input.length-1 ? lowestI+i-input.length : lowestI+i;
            tmp[i] = input[newIndex];
        }
        String toReturn = "";
        for (int[] ar : tmp) {
            for (int i : ar) {
                toReturn += i;
            }
        }
        return Long.parseLong(toReturn);
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
        // Fill outer circle
        for (int i = 0; i < size; i++) {
            sol[i][0] = tmp.get(i);
        }
        // Fill inner circle
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
                System.out.println(valueOf(doMagic(s)));
                System.exit(0);
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

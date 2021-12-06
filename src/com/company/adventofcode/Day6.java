package com.company.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6 {

    public static void main(String[] args) {
        Day6 day = new Day6();
        List<Integer> test = new ArrayList<>(Arrays.asList(3,4,3,1,2));
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,4,5,5,5,2,1,3,1,4,3,2,1,5,5,1,2,3,4,4,1,2,3,2,1,4,4,1,5,5,1,3,4,4,4,1,2,2,5,1,5,5,3,2,3,1,1,3,5,1,1,2,4,2,3,1,1,2,1,3,1,2,1,1,2,1,2,2,1,1,1,1,5,4,5,2,1,3,2,4,1,1,3,4,1,4,1,5,1,4,1,5,3,2,3,2,2,4,4,3,3,4,3,4,4,3,4,5,1,2,5,2,1,5,5,1,3,4,2,2,4,2,2,1,3,2,5,5,1,3,3,4,3,5,3,5,5,4,5,1,1,4,1,4,5,1,1,1,4,1,1,4,2,1,4,1,3,4,4,3,1,2,2,4,3,3,2,2,2,3,5,5,2,3,1,5,1,1,1,1,3,1,4,1,4,1,2,5,3,2,4,4,1,3,1,1,1,3,4,4,1,1,2,1,4,3,4,2,2,3,2,4,3,1,5,1,3,1,4,5,5,3,5,1,3,5,5,4,2,3,2,4,1,3,2,2,2,1,3,4,2,5,2,5,3,5,5,1,1,1,2,2,3,1,4,4,4,5,4,5,5,1,4,5,5,4,1,1,5,3,3,1,4,1,3,1,1,4,1,5,2,3,2,3,1,2,2,2,1,1,5,1,4,5,2,4,2,2,3));
//        day.solution(test, 18);
        day.calc(test,18);
    }

    private void solution(List<Integer> list, int days) {
        if(days ==0){
            System.out.println("Solution: " + list.size());
            System.out.println(list);
            return;
        }
        int toAdd =0;
        for(int i=0; i< list.size();i++){
            if(list.get(i)==0){
                toAdd++;
                list.set(i,6);
            }else{
                list.set(i,list.get(i)-1);
            }
        }
        for(int i =0; i< toAdd; i++){
            list.add(8);
        }
        solution(list,days-1);
    }

    private void calc(List<Integer> list, int days){
        int a = days%7;
        for(int i=0; i< list.size();i++){
            int b = list.get(i) -a;
            if(b < 0){
                b=7+b;
            }
            list.set(i, b);
        }
        System.out.println(list + " " );
    }
}

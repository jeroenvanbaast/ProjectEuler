package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Problem4 {

    public static void main(String... args){
        System.out.println(getHighestPalindrome());
    }


    public static boolean isPalindrome(int x){
        String y = Integer.toString(x);
        String a = y.substring(0,y.length()/2);
        String b = y.substring(y.length()/2);
        return new StringBuilder(b).reverse().toString().equals(a);
    }

    public static int getHighestPalindrome(){
        ArrayList<Integer> t = new ArrayList<>();
        for(int i = 999; i>100; i--){
            for(int ii = 999; ii>100; ii--){
                if(isPalindrome(i*ii)){
                    t.add(i*ii);
                }
            }
        }
        Collections.sort(t);
        return t.get(t.size()-1);
    }
}

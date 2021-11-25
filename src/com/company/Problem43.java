package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem43 {

    List<String> pandigitals = new ArrayList<>();

    public static void main(String[] args) {
        Problem43 p = new Problem43();
        p.generatePandigitals("", Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        p.solution();
    }

    public void solution(){
        BigInteger big = BigInteger.ZERO;
       for(String s: pandigitals){
           if(check(s)){
               System.out.println(s);
               big = big.add(new BigInteger(s));
           }
       }
        System.out.println("Solution: " +big);
    }

    public boolean check(String a){
        int[] b = new int[]{2,3,5,7,11,13,17};
        for(int i = 0; i <7;i++){
            if(Integer.parseInt(a.substring(i+1,i+4)) % b[i] !=0){
                return false;
            }
        }
        return true;
    }

    public void generatePandigitals(String p, List<String> remainder) {
        if (remainder.size() ==0){
            pandigitals.add(p);
            return;
        }
        for(String s: remainder){
            List<String> coppy = new ArrayList<>(List.copyOf(remainder));
            coppy.remove(s);
            generatePandigitals(p.concat(s),coppy);
        }
    }
}

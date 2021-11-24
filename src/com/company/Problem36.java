package com.company;

public class Problem36 {

    public static void main(String[] args) {
        Problem36 p = new Problem36();
        p.solution();

    }

    public void solution(){
        long sum = 0;
        for(int i =0; i< 1_000_000; i++){
            String a = String.valueOf(i);
            String b = Integer.toBinaryString(i);
            if(isPalindromic(a) && isPalindromic(b)){
                sum+= i;
            }
        }
        System.out.println("Solution: " + sum);
    }

    public boolean isPalindromic(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }

}

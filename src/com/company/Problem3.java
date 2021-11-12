package com.company;

import java.util.ArrayList;

public class Problem3 {

    public static void main(String[] args){
        ArrayList<Integer> primeNumbers = primeNumbers(10000);
        ArrayList<Integer> v = new ArrayList<>();
        long n = 600851475143L;
        while(n!=1){
            for(Integer i: primeNumbers){
                if(n%i == 0){
                    n=n/i;
                    v.add(i);
                    break;
                }
            }
            System.out.println(v);
        }
        System.out.println(v);
    }

    static ArrayList<Integer> primeNumbers(int n){
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            int counter=0;
            for(int num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}

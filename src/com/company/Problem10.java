package com.company;

import java.util.ArrayList;
import java.util.HashMap;

// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
// Find the sum of all the primes below two million.
public class Problem10 {

    Long sum =0L;
    public static void main (String... args){
        Problem10 p10 = new Problem10();
//        System.out.println(p10.primeNumbers(2000000));
        p10.primeNumbersBetter(10);
        System.out.println(p10.sum);
    }

    public ArrayList<Integer> primeNumbers(int n){
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        if (n >= 2) {
            primeNumbers.add(2);
        }
        for (int i = 1; i <= n; i+=2)
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
                sum += i;
                System.out.println(i);
            }
        }
        return primeNumbers;
    }

    public void primeNumbersBetter(int n){
        ArrayList<Integer>h = new ArrayList<>();
        for (int i = 3; i <= n; i+=2)
        {
            h.add(i);
        }
        int lastSize = h.size();
        int newSize = 1;
        while(lastSize > newSize){
            if(h.size()==0){
                break;
            }
            int i = h.get(0);
            if(isPrime(i)){
                sum+=i;
                System.out.println(i);
            }
            h.removeIf(hi -> hi % i == 0);
            newSize = h.size();
        }

    }

    public Boolean isPrime(int number){
        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

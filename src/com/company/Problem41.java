package com.company;

import java.util.HashSet;

public class Problem41 {

    public static void main(String[] args) {
        Problem41 p = new Problem41();
        p.solution();
    }

    // https://en.wikipedia.org/wiki/Divisibility_rule#Divisibility_by_3_or_9
    // A number is divisible by 3 if the digit sum of the number is divisible by 3 so:
    //1+2+3+4+5+6+7+8+9 = 45
    //1+2+3+4+5+6+7+8 = 36
    //1+2+3+4+5+6+7 = 28
    // 45 and 36 are divisible by 3 and numbers only using those digits can never be a prime number.
    // We go top down starting at the highest possible pandigital prime number : 7654321
    public void solution() {
        for (long i = 7_654_321; i > 1; i--) {
            if (isPandigital(String.valueOf(i)) && isPrime(i)) {
                System.out.println("Solution: " + i);
                return;
            }
        }
    }

    public Boolean isPrime(long number) {
        for (int i = 3; i <= number/2; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPandigital(String a) {
        HashSet<String> h = new HashSet<>();
        h.add("0");
        for(int i =9; i> a.length();i--){
            h.add(""+ i);
        }
        for (char c : a.toCharArray()) {
            if(!h.add(""+c)){
                return false;
            }
        }
        return h.size() == 10;
    }
}

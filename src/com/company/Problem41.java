package com.company;

import java.util.HashSet;

public class Problem41 {

    public static void main(String[] args) {
        Problem41 p = new Problem41();
        p.solution();
    }

    public void solution() {
        for (long i = 20_000_000; i > 1; i--) {
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

package com.company;

import java.util.HashSet;

public class Problem38 {

    public static void main(String[] args) {
        Problem38 p = new Problem38();
        p.solution();
    }

    public void solution() {
        int h = 0;
        String a = "";
        for (int i = 1; i < 1_000_000; i++) {
            int j = 1;
            while (a.length() < 9) {
                a += (i * j);
                j++;
            }
            if (a.length() < 10 &&isPandigital(a)) {
                h = Math.max(Integer.parseInt(a), h);
            }
            a = "";
        }
        System.out.println(h);
    }

    public boolean isPandigital(String i) {
        HashSet<Character> h = new HashSet<>();
        for (char c : i.toCharArray()) {
            if(c == '0'){
                return false;
            }
            h.add(c);
        }
        return h.size() == 9;
    }
}

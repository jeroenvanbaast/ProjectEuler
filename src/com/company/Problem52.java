package com.company;

public class Problem52 {

    public static void main(String[] args) {
        Problem52 p = new Problem52();
        p.solution();
    }

    private void solution() {
        for(int i = 125874; i<1_000_000;i++){
            if(sameDigits(i, i*2) && sameDigits(i, i*3) && sameDigits(i, i*4)&& sameDigits(i, i*5) && sameDigits(i, i*6)){
                System.out.println(i);
            }
        }
    }

    private boolean sameDigits(long x, long y){
        String a = ""+x;
        String b = ""+y;
        if(a.length()!=b.length()){
            return false;
        }
        char[] bchars = b.toCharArray();
        out:
        for (char c : a.toCharArray()) {
            for (int i = 0; i < bchars.length; i++) {
                if (c == bchars[i]) {
                    bchars[i] = 'a';
                    continue out;
                }
            }
            return false;
        }
        return true;
    }
}

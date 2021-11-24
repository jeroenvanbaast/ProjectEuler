package com.company;

public class Problem39 {

    public static void main(String[] args) {
        Problem39 p = new Problem39();
        p.solution();
    }

    public void solution() {
        int h = 0;
        int ans = 0;
        for (int p = 0; p <= 1000; p++) {
            int k = test(p);
            if (h < k) {
                h=k;
                ans = p;
            }
        }
        System.out.println("solution: " + ans);
    }

    public int test(int p) {
        int count = 0;
        for (int a = 1; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                int c = (int) Math.sqrt(a * a + b * b);
                if (c * c == a * a + b * b) {
                    if (a + b + c == p) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

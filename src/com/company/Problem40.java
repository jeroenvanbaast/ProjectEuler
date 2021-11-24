package com.company;

public class Problem40 {

    public static void main(String[] args) {
        Problem40 p = new Problem40();
        p.solution();
    }

    public void solution() {
        String s = buildIt();
        int a = Integer.parseInt(s.substring(0, 1)) * Integer.parseInt(s.substring(9, 10)) * Integer.parseInt(s.substring(99, 100))
                * Integer.parseInt(s.substring(999, 1_000)) * Integer.parseInt(s.substring(9_999, 10_000))
                * Integer.parseInt(s.substring(99_999, 100_000)) * Integer.parseInt(s.substring(999_999, 1_000_000));
        System.out.println(a);
    }

    public String buildIt() {
        String s = "";
        int i = 1;
        while (s.length() < 1_000_000) {
            s += i++;
        }
        return s;
    }
}

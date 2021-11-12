package com.company;

import java.util.ArrayList;

public class Problem6 {

    public static void main(String... args) {
        int a = 0;
        int b = 0;
        for (int i = 1; 100 >= i; i++) {
            a+= i*i;
            b+= i;
        }
        b =b*b;
        System.out.println(b-a);
    }
}

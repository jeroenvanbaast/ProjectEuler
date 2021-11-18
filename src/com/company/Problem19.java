package com.company;

public class Problem19 {

    // How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
    public static void main(String... args) {
        int day = 1;
        int year = 1901;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leap = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        for (int i = year; i < 2001; i++) {
            if (i % 4 == 0) {
                for (int d : leap) {
                    day += d;
                    day = day % 7;
                    System.out.println(day);
                    if(day == 6){
                        count++;
                    }
                }
            } else {
                for (int d : days) {
                    {
                        day += d;
                        day = day % 7;
                        System.out.println(day);
                        if(day == 6){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}

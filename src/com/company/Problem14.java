package com.company;

public class Problem14 {


    public static void main(String... args) {
        Problem14 p14 = new Problem14();
//        System.out.println(p14.seqCount(837799L, 1));
        System.out.println(p14.sol(1000001));
    }

    public long sol(int n) {
        int h = 0;
        long start = 0;
        for (long i = 1; i < n; i++) {
            int count = seqCount( i, 1);
            if (count > h) {
                System.out.println(" startNr:" + i + " count:" + count);
                h = count;
                start = i;
            }
        }
        return start;
    }

    public Integer seqCount(Long num, int count) {
        if (num % 2 == 0) {
            return seqCount(num / 2, ++count);
        } else if( num > 2) {
            return seqCount(3 * num + 1, ++count);
        }
        return count;
    }
}

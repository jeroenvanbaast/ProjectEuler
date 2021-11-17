package com.company;

public class Problem24 {

    // 012   021   102   120   201   210
    public static void main(String... args) {
//        int[] t = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] t = new int[]{0, 1, 2};
        int[] k = new int[]{0, 1, 2};
        for (int i = 0; i < 6; i++) {
            System.out.println(k[0] + " " + k[1] + " " + k[2]);
            k = next(k);
        }
    }

    public static int[] next(int[] k){
        int j = 0;
        for(int i : k){
            if(i>j){
                j=i;
            }
        }
        k[j]=0;
        return k;
    }
}

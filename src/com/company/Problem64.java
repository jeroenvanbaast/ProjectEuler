package com.company;

public class Problem64 {

    public static void main(String[] args) {
        Problem64 p = new Problem64();
        p.solution(12);// [10; 1,2,10,2,1,20]

    }
    private void solution(int n) {
        int d =1;
        int m =0;
        int a = (int) Math.sqrt(n);
        int a0 =(int) Math.sqrt(n);
        String output = "["+a0 + ";(";
        for(int i =0; i< 6;i++){
            int mx = d*a-m;
            int dx = (n-(mx*mx)) / d;
            int ax = (a0+mx)/dx;
            output+=ax+",";
            d = dx;
            m = mx;
            a = ax;
        }
        System.out.println(output.substring(0,output.length()-1)+")]");
    }

    private void solutionHardCoded() {
        int n = 114;
        int d0 =1;
        int m0 =0;

        int a0 = (int) Math.sqrt(n);
        int d1 =n-a0*a0;
        int m1 = a0*d0-m0;
        int a1 = (a0+m1)/d1;


        int m2 = d1*a1-m1;
        int d2 = (n-(m2*m2)) / d1;
        int a2 = (a0+m2)/d2;


        int m3 = d2*a2-m2;
        int d3 = (n-(m3*m3)) / d2;
        int a3 = (a0+m3)/d3;


        int m4 = d3*a3-m3;
        int d4 = (n-(m4*m4)) / d3;
        int a4 = (a0+m4)/d4;

        int m5 = d4*a4-m4;
        int d5 = (n-(m5*m5)) / d4;
        int a5 = (a0+m5)/d5;

        int m6 = d5*a5-m5;
        int d6 = (n-(m6*m6)) / d5;
        int a6 = (a0+m6)/d6;
        System.out.println(a0 + " " +a1 + " " + a2 + " " + a3 + " " + a4 + " " + a5 + " " + a6); // [10; 1,2,10,2,1,20]
    }



    public void continuedFraction(int numerator, int denominator) {
        while (true) {
            int a = numerator / denominator;
            int tmp = numerator - (a * denominator);
            numerator = denominator;
            denominator = tmp;
            System.out.println(a);
            if(tmp<=0){
                break;
            }
        }
    }
}

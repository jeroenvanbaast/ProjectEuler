package com.company;

public class Problem45 {

    public static void main(String[] args) {
        Problem45 p = new Problem45();
        p.solution();
    }

    public void solution(){
        for(int i = 144; i< 1_000_000_000; i++){
            long a = i*(2*i-1);
            if(isTriangular(a) && isPentagonal(a)){
                System.out.println(i + " " + a);
                break;
            }
        }
    }

    public boolean isTriangular(long a){
        double d = (Math.sqrt(8*a+1)-1)/2;
        return d%1 == 0;
    }

    public boolean isPentagonal(long a){
        double d = (Math.sqrt(24*a+1)+1)/6;
        return d%1 == 0;
    }

    public boolean isHexagonal(long a){
        double d = (Math.sqrt(8*a+1)+1)/4;
        return d%1 == 0;
    }
}

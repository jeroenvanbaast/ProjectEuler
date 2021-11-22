package com.company;

public class Problem30 {

    public static void main(String... args) {
        Problem30 p = new Problem30();
        p.solution();
    }

    public void solution(){
        int sum = 0;
        for(int i=2;i<10000000;i++){
            if(check(i)){
                sum+=i;
                System.out.println(i);
            }
        }
        System.out.println("Solution: " + sum);
    }

    public boolean check(int i){
        int s = 0;
        for(char c : String.valueOf(i).toCharArray()){
            s+= Math.pow(Integer.valueOf(""+c),5);
        }
        return s ==i;
    }
}

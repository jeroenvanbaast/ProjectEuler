package com.company;

public class Problem21 {

    public static void main(String... args){
        Problem21 p = new Problem21();
        p.solution(10000);
    }

    public void solution(int n){
        int count = 0;
        for(int i=1; i < n;i++){
            int t = properDivisors(i);
            if(i != t && i == properDivisors(t)){
                System.out.println(i + " " + t);
                count +=i;
            }
        }
        System.out.println("Answer: " + count);
    }

    public int properDivisors(int a){
        int b = a/2 +1;
        int count = 0;
        for(int i = 1; i < b; i++){
            if(a%i == 0){
                count+=i;
            }
        }
        return count;
    }
}

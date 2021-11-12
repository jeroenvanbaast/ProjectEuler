package com.company;

public class Problem5 {

    public static void main(String... args){
        for(int i = 2520; true; i++){
            if(test(i)){
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean test(int i){
        for(int k = 1; k <= 20; k++){
            if(i%k !=0){
                return false;
            }
        }
        return true;
    }
}

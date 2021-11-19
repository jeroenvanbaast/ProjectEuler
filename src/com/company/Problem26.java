package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem26 {

    public static void main(String... args) {
        Problem26 p = new Problem26();
        System.out.println(p.solution(1000));
    }

    public int solution(int a){
        int result =0;
        int answer =0;
        for(int i =a; i>1;i-- ){
            if(result >=i){
                break;
            }
            int[] found = new int[i];
            int v =1;
            int j=0;
            while(found[v] ==0 && v!=0){
                found[v] = j;
                v = v*10%i;
                j++;
            }
            if(j - found[v] > result){
                result = j-found[v];
                answer = i;
            }
        }
        return answer;
    }


}

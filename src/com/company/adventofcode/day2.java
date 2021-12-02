package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class day2 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> t = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/day2.txt")));
        System.out.println(t);
        day2 d = new day2();
        d.solution(t);
    }

    public void solution(ArrayList<String> moves) {
        int hor = 0;
        int depth = 0;
        int aim =0;
        for (String s: moves){
            int a = Integer.parseInt(s.substring(s.length()-1));
            if(s.contains("forward")){
                hor +=a;
                depth+= (aim*a);
            }else if(s.contains("up")){
                aim-=a;
            }else if (s.contains("down")){
                aim+= a;
            }
        }
        System.out.println(hor + " " + depth + " Solutiong: " +(hor*depth));
    }
}

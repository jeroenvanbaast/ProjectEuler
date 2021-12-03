package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> t = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/test.txt")));
        ArrayList<String> a = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/day3.txt")));
        Day3 d = new Day3();
        d.solution2(a);
    }

    private void solution2(ArrayList<String> a) {
        int ox = oxygen(new ArrayList<>(a),0,"");
        int co2 = co2(new ArrayList<>(a),0,"");
        System.out.println("Solution: " + (ox * co2));
    }

    private int oxygen(ArrayList<String> a, int i, String oxygen) {
        if(a.size() ==1){
            return Integer.parseInt(oxygen, 2);
        }
        int count = 0;
        for (String s : a) {
            count += Integer.parseInt(""+s.charAt(i));
        }
        double d = a.size() / (double)2;
        String x = "";
        if((double)count >= d){
            a.removeIf(s -> s.charAt(i) != '1' );
            x+="1";
        }else{
            a.removeIf(s -> s.charAt(i) != '0' );
            x+="0";
        }
        return oxygen(a,i+1,oxygen+x);
    }

    private int co2(ArrayList<String> a, int i, String co2) {
        if(a.size() ==1){
            return Integer.parseInt(a.get(0), 2);
        }
        int count = 0;
        for (String s : a) {
            count += Integer.parseInt(""+s.charAt(i));
        }
        double d = a.size() / (double)2;
        String x = "";
        if((double)count >= d){
            a.removeIf(s -> s.charAt(i) != '0' );
            x+="0";
        }else{
            a.removeIf(s -> s.charAt(i) != '1' );
            x+="1";
        }
        return co2(a,i+1,co2+x);
    }

    private void solution(ArrayList<String> a) {
        String gama = "";
        String epsilon = "";
        int[] tmp = new int[a.get(0).length()];
        for (String s : a) {
            int i = 0;
            for (char c : s.toCharArray()) {
                tmp[i] += Integer.parseInt("" + c);
                i++;
            }
        }
        int half = a.size() / 2;
        for (int i : tmp) {
            if (i > half) {
                gama += "1";
                epsilon += "0";
            } else if (i < half) {
                gama += "0";
                epsilon += "1";
            } else {
                System.out.println("Something went wrong");
            }
        }
        int power = Integer.parseInt(gama, 2) * Integer.parseInt(epsilon, 2);
        System.out.println("Solution: " + power);
    }
}

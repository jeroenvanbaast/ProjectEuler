package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day10 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day10.txt")));
        new Day10().solution(input);
    }

    private void solution(ArrayList<String> test) {
        int ans =0;
        ArrayList<Long> scores = new ArrayList<>();
       outer:  for (String line : test) {
           ArrayList<String> a = new ArrayList<>();
            for (char c : line.toCharArray()) {
                String s = "" + c;
                if (s.equals(")")) {
                    if(!a.get(a.size()-1).equals("(")){
                        ans+=3;
                        continue outer;
                    }
                    a.remove(a.size()-1);
                } else if (s.equals("]")) {
                    if(!a.get(a.size()-1).equals("[")){
                        ans+=57;
                        continue outer;
                    }
                    a.remove(a.size()-1);
                } else if (s.equals("}")) {
                    if(!a.get(a.size()-1).equals("{")){
                        ans+=1197;
                        continue outer;
                    }
                    a.remove(a.size()-1);
                } else if (s.equals(">")) {
                    if(!a.get(a.size()-1).equals("<")){
                        ans+=25137;
                        continue outer;
                    }
                    a.remove(a.size()-1);
                } else {
                    a.add(s);
                }
            }
            long tmp = 0;
            for(int i = a.size()-1; i>=0; i--){
                String s = a.get(i);
                if (s.equals("(")) {
                    tmp = tmp*5+1;
                } else if (s.equals("[")) {
                    tmp = tmp*5+2;
                } else if (s.equals("{")) {
                    tmp = tmp*5+3;
                } else if (s.equals("<")) {
                    tmp = tmp*5+4;
            }}
            scores.add(tmp);
        }
        System.out.println("Solution1: " + ans);
        System.out.println("Solution2: " + scores.stream().sorted().collect(Collectors.toList()).get(scores.size()/2));
    }
}

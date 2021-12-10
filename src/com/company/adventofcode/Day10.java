package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day10 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/test.txt")));
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day10.txt")));
        Day10 d = new Day10();
        d.solution1(input);
        d.solution2(input);
    }

    private void solution2(ArrayList<String> input) {
    }

    private void solution1(ArrayList<String> test) {
        ArrayList<String> a = new ArrayList<>();
        int ans =0;
        for (String line : test) {
            for (char c : line.toCharArray()) {
                String s = "" + c;
                if (s.equals(")")) {
                    if(!a.get(a.size()-1).equals("(")){
                        ans+=3;
                        break;
                    }
                    a.remove(a.size()-1);
                } else if (s.equals("]")) {
                    if(!a.get(a.size()-1).equals("[")){
                        ans+=57;
                        break;
                    }
                    a.remove(a.size()-1);
                } else if (s.equals("}")) {
                    if(!a.get(a.size()-1).equals("{")){
                        ans+=1197;
                        break;
                    }
                    a.remove(a.size()-1);
                } else if (s.equals(">")) {
                    if(!a.get(a.size()-1).equals("<")){
                        ans+=25137;
                        break;
                    }
                    a.remove(a.size()-1);
                } else {
                    a.add(s);
                }
            }
        }
        System.out.println("Solution: " + ans);
    }
}

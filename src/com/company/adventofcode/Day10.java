package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day10 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day10.txt")));
        new Day10().solution(input);
    }

    private void solution(ArrayList<String> test) {
        int ans = 0;
        String b = "0([{<";
        ArrayList<Long> scores = new ArrayList<>();
        outer:
        for (String line : test) {
            Stack<String> a = new Stack();
            for (char c : line.toCharArray()) {
                String s = "" + c;
                if ("({[<".contains(s)) {
                    a.add(s);
                } else if (s.equals(")")) {
                    if (!a.pop().equals("(")) {
                        ans += 3;
                        continue outer;
                    }
                } else if (s.equals("]")) {
                    if (!a.pop().equals("[")) {
                        ans += 57;
                        continue outer;
                    }
                } else if (s.equals("}")) {
                    if (!a.pop().equals("{")) {
                        ans += 1197;
                        continue outer;
                    }
                } else if (s.equals(">")) {
                    if (!a.pop().equals("<")) {
                        ans += 25137;
                        continue outer;
                    }
                }
            }
            long[] tmp = {0};
            a.stream().sorted().forEach(p -> tmp[0] = tmp[0] * 5 + b.indexOf(a.pop()));
            scores.add(tmp[0]);
        }
        System.out.println("Solution1: " + ans);
        System.out.println("Solution2: " + scores.stream().sorted().collect(Collectors.toList()).get(scores.size() / 2));
    }
}

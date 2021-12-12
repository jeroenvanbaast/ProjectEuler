package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class Day12 {

    int count = 0;

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day12.txt")));
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/test.txt")));
        Day12 d = new Day12();
        d.solution(d.reverse(input), "start", "", false);
        System.out.println("Solution: " + d.count);
    }

    private void solution(ArrayList<String> input, String toAdd, String route, boolean first) {
        if (Objects.equals(toAdd, "end")) {
            System.out.println(route + toAdd);
            count++;
            return;
        }
        for (String s : input) {
            String[] parts = s.split("-");
            if (parts[0].equals(toAdd)) {
                if (!route.contains(parts[1].toLowerCase())) {
                    solution(input, parts[1], route + toAdd + ",", first);
                }else{
                    if(!first && !parts[1].equals("start") && !parts[1].equals("end")){
                        solution(input, parts[1], route + toAdd + ",", true);
                    }
                }
            }
        }
    }


    private ArrayList<String> reverse(ArrayList<String> input) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (String s : input) {
            toReturn.add(s);
            String[] a = s.split("-");
            toReturn.add(a[1] + "-" + a[0]);
        }
        return toReturn;
    }
}

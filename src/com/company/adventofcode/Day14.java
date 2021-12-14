package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day14 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day14.txt")));
        Day14 d = new Day14();
        d.solution(input.get(0), input.subList(2, input.size()));
    }

    private void solution(String polymerTemplate, List<String> subList) {
        HashMap<String, String> input = new HashMap<>();
        for (String s : subList) {
            input.put(s.substring(0, 2), String.valueOf(s.charAt(6)));
        }
        HashMap<String, Long> pairs = new HashMap<>();
        for (int i = 0; i < polymerTemplate.length() - 1; i++) {
            Long val = pairs.getOrDefault(polymerTemplate.substring(i, i + 2), 0L);
            pairs.put(polymerTemplate.substring(i, i + 2), val + 1L);
        }
        for (int step = 1; step <= 40; step++) {
            HashMap<String, Long> tmp = new HashMap<>();
            for (Map.Entry<String, Long> entry : pairs.entrySet()) {
                String a = entry.getKey().charAt(0) + input.get(entry.getKey());
                Long valA = tmp.getOrDefault(a, 0L);
                tmp.put(a, valA + entry.getValue());

                String b = input.get(entry.getKey()) + entry.getKey().charAt(1);
                Long valB = tmp.getOrDefault(b, 0L);
                tmp.put(b, valB + entry.getValue());
            }
            pairs = tmp;
        }
        HashMap<Character, Long> test = new HashMap<>();
        for (Map.Entry<String, Long> entry : pairs.entrySet()) {
            char a = entry.getKey().charAt(0);
            Long valA = test.getOrDefault(a, 0L);
            test.put(a, valA + entry.getValue());
        }
        Long high = 0L;
        Long low = 999999999999999999L;
        for (Map.Entry<Character, Long> e : test.entrySet()) {
            if (e.getKey() == polymerTemplate.charAt(polymerTemplate.length() - 1)) {
                high = Math.max(high, e.getValue()+1);
                low = Math.min(low, e.getValue()+1);
            } else {
                high = Math.max(high, e.getValue());
                low = Math.min(low, e.getValue());
            }
        }
        System.out.println("Solution: " + (high - low));
    }

}

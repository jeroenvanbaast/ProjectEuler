package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day14 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day14.txt")));
        new Day14().solution(input.get(0), input.subList(2, input.size()).stream().collect(Collectors.toMap(s -> s.substring(0, 2), s-> String.valueOf(s.charAt(6)))));
    }

    private void solution(String polymerTemplate, Map<String, String> input) {
        Map<String, Long> pairs = new HashMap<>();
        for (int i = 0; i < polymerTemplate.length() - 1; i++) {
            Long val = pairs.getOrDefault(polymerTemplate.substring(i, i + 2), 0L);
            pairs.put(polymerTemplate.substring(i, i + 2), val + 1L);
        }
        for (int step = 1; step <= 40; step++) {
            pairs = Stream.of(
            pairs.entrySet().stream().collect(Collectors.toMap(e ->  e.getKey().charAt(0) + input.get(e.getKey()), Map.Entry::getValue, Long::sum)),
            pairs.entrySet().stream().collect(Collectors.toMap(e ->  input.get(e.getKey()) + e.getKey().charAt(1), Map.Entry::getValue, Long::sum)))
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum));
        }
        Map<Character, Long> test = pairs.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().charAt(0), Map.Entry::getValue, Long::sum));
        char last = polymerTemplate.charAt(polymerTemplate.length()-1);
        test.put(last, test.get(last)+1);
        System.out.println("Solution: " + (test.values().stream().max(Long::compareTo).get() - test.values().stream().min(Long::compareTo).get()));
    }

}

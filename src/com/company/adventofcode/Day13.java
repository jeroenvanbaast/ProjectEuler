package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Day13 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day13.txt")));
        new Day13().solution(input, (int) input.stream().filter(s -> s.contains("=")).count());
    }

    private void solution(ArrayList<String> input, int folds) {
        ArrayList<String> foldLines = new ArrayList<>(input.subList(input.size() - folds, input.size()));
        input.removeAll(input.subList(input.size()-folds-1, input.size()));
        boolean[][] paper = dotPaper(input);
        for (String fold : foldLines) {
            String[] parts = fold.split(" ");
            int line = Integer.parseInt(parts[2].substring(2));
            if (parts[2].contains("y")) {
                boolean[][] topHalf = Arrays.copyOfRange(paper, 0, line);
                boolean[][] botHalf = Arrays.copyOfRange(paper, line + 1, paper.length);
                for (int i = topHalf.length - 1; i >= 0; i--) {
                    for (int k = 0; k < topHalf[0].length; k++) {
                        topHalf[i][k] = botHalf[topHalf.length - i - 1][k] || topHalf[i][k];
                    }
                }
                paper = topHalf;
            } else {
                boolean[][] leftHalf = new boolean[paper.length][line];
                boolean[][] rightHalf = new boolean[paper.length][paper[0].length - line - 1];
                for (int i = 0; i < paper.length; i++) {
                    leftHalf[i] = Arrays.copyOfRange(paper[i], 0, line);
                    rightHalf[i] = Arrays.copyOfRange(paper[i], line + 1, paper[i].length);
                }
                for (int i = 0; i < leftHalf.length; i++) {
                    for (int k = leftHalf[0].length - 1; k >= 0; k--) {
                        leftHalf[i][k] = leftHalf[i][k] || rightHalf[i][leftHalf[0].length - k - 1];
                    }
                }
                paper = leftHalf;
            }
        }
        Arrays.stream(paper).forEach(x -> System.out.println(IntStream.range(0, x.length)
                .mapToObj(idx -> x[idx]).map(a-> a?"#" : " ").reduce((a,b) -> a+b).get()));
        System.out.println("Solution1: " + Arrays.stream(paper).flatMap(x -> IntStream.range(0, x.length)
                .mapToObj(idx -> x[idx]).filter(a -> a)).count());
    }

    private boolean[][] dotPaper(ArrayList<String> input) {
        boolean[][] paper = new boolean[15000][11000];
        input.forEach(a -> paper[Integer.parseInt(a.split(",")[1])][Integer.parseInt(a.split(",")[0])] = true);
        return paper;
    }
}

package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day9 {

    ArrayList<Integer> basins = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int[][] input = Arrays.stream(Files.readString(Path.of("src/com/company/adventofcode/day9.txt")).split("\r\n"))
                .map(r ->Arrays.stream(r.split("")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        new Day9().solution(input);
    }

    private void solution(int[][] input) {
        int basinCount = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                int current = input[i][j];
                if (current!=-1 && current!= 9) {
                    basins.add(0);
                    basinSize(input, i, j, basinCount++);
                }
            }
        }
        System.out.println("Solution: " + basins.stream().sorted(Collections.reverseOrder()).limit(3).mapToInt(s -> s).reduce(1, (a, b) -> a * b));
    }

    private void basinSize(int[][] map, int i, int j, int index) {
        if (map[i][j] == -1) {
            return;
        }
        if (map[i][j] != 9) {
            basins.set(index, basins.get(index) + 1);
            map[i][j] = -1;
            if (j != 0) {
                basinSize(map, i, j - 1, index);
            }
            if (j < map[0].length - 1) {
                basinSize(map, i, j + 1, index);
            }
            if (i != 0) {
                basinSize(map, i - 1, j, index);
            }
            if (i < map.length - 1) {
                basinSize(map, i + 1, j, index);
            }
        }
    }
}

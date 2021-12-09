package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day9 {

    public static void main(String[] args) throws IOException {
        int[][] input = Arrays.stream(Files.readString(Path.of("src/com/company/adventofcode/day9.txt")).split("\r\n"))
                .map(r ->Arrays.stream(r.split("")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        new Day9().solution(input);
    }

    private void solution(int[][] input) {
        ArrayList<Integer> basins = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                int current = input[i][j];
                if (current!=-1 && current!= 9) {
                    basins.add(basinSize(input, i, j, 0));
                }
            }
        }
        System.out.println("Solution: " + basins.stream().sorted(Collections.reverseOrder()).limit(3).mapToInt(s -> s).reduce(1, (a, b) -> a * b));
    }

    private int basinSize(int[][] map, int i, int j, int ans) {
        if (map[i][j] != 9 && map[i][j] != -1) {
            ++ans;
            map[i][j] = -1;
            if (j != 0) {
                ans = basinSize(map, i, j - 1, ans);
            }
            if (j < map[0].length - 1) {
                ans = basinSize(map, i, j + 1, ans);
            }
            if (i != 0) {
                ans = basinSize(map, i - 1, j, ans);
            }
            if (i < map.length - 1) {
                ans = basinSize(map, i + 1, j, ans);
            }
        }
        return ans;
    }
}

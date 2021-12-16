package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Day15 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day15.txt")));
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/test.txt")));
        Day15 day15 = new Day15();
        day15.solution(input);
    }

    private void solution(ArrayList<String> input) {
        int[][] map = makeMap(input);
        int[][] minValues = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                minValues[i][j] = 9999999;
            }
        }
        minValues[0][0] = 0;
        int ans = 99999999;
        int lastAns = 0;
        while (ans != lastAns) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (j < map.length - 1) {
                        minValues[i][j + 1] = Math.min(minValues[i][j] + map[i][j + 1], minValues[i][j + 1]);
                    }
                    if (i < map[0].length - 1) {
                        minValues[i + 1][j] = Math.min(minValues[i][j] + map[i + 1][j], minValues[i + 1][j]);
                    }
                    if (i != 0) {
                        minValues[i - 1][j] = Math.min(minValues[i][j] + map[i - 1][j], minValues[i - 1][j]);
                    }
                    if (j != 0) {
                        minValues[i][j - 1] = Math.min(minValues[i][j] + map[i][j - 1], minValues[i][j - 1]);
                    }
                }
            }
            lastAns = ans;
            ans = minValues[minValues.length - 1][minValues[0].length - 1];
        }
        System.out.println("Solution: " + ans);
    }

    private int[][] makeMap(ArrayList<String> input) {
        int k = input.size();
        int[][] part = new int[k][k];
        int[][] map = new int[k * 5][k * 5];
        int i = 0;
        for (String s : input) {
            int j = 0;
            for (char c : s.toCharArray()) {
                map[i][j] = Integer.parseInt("" + c);
                part[i][j++] = Integer.parseInt("" + c);
            }
            i++;
        }
        for (int x = 0; x < k * 5; x++) {
            for (int y = 0; y < k * 5; y++) {
                if (map[x][y] != 0) {
                    continue;
                }
                int a = x >= k ? x - k : x;
                int b =y;
                if (a == x) {
                    b = y >= k ? y - k : y;
                }
                int t = map[a][b];
                map[x][y] = t + 1;
                if (map[x][y] >= 10) {
                    map[x][y] = idk(map[x][y]);
                }
            }
        }
        return map;
    }

    private int idk(int a) {
        while (true) {
            if (a >= 10) {
                a = a - 9;
            } else {
                return a;
            }
        }
    }

    private void makeAndPrintMap(ArrayList<String> input) {
        int[][] map = makeMap(input);
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
    }
}

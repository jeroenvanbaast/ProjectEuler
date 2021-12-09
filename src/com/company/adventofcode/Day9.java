package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Day9 {

    ArrayList<Integer> basins = new ArrayList<>();

    // 1019494;
    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day9.txt")));
        Day9 day9 = new Day9();
        day9.solution(day9.makeMap(input));
    }

    private int[][] makeMap(ArrayList<String> input) {
        int[][] toReturn = new int[input.size()][input.get(0).length()];
        int i = 0;
        for (String s : input) {
            int j = 0;
            for (char c : s.toCharArray()) {
                toReturn[i][j] = Integer.parseInt("" + c);
                j++;
            }
            i++;
        }
        return toReturn;
    }

    private void solution(int[][] input) {
        int x = input.length;
        int y = input[0].length;
        int basinCount = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int current = input[i][j];
                if ((j != 0 && input[i][j - 1] > current) && (j < y - 1 && input[i][j + 1] > current) &&
                        (i != 0 && input[i - 1][j] > current) && (i < x - 1 && input[i + 1][j] > current)) {
                    basins.add(0);
                    basinSize(input, i, j, basinCount++);
                }
            }
        }
        Collections.sort(basins);
        int k = basins.size()-1;
        System.out.println("Solution: " + (basins.get(k--) * basins.get(k--) * basins.get(k)));

    }

    private void basinSize(int[][] map, int i, int j, int index) {
        if (map[i][j] == -1) {
            return;
        }
        basins.set(index, basins.get(index) + 1);
        map[i][j] = -1;
        if (j != 0 && map[i][j - 1] != 9) {
            basinSize(map, i, j-1, index);
        }
        if (j < map[0].length - 1 && map[i][j + 1] != 9) {
            basinSize(map, i, j+1, index);
        }
        if (i != 0 && map[i - 1][j] != 9) {
            basinSize(map, i-1, j, index);
        }
        if (i < map.length - 1 && map[i + 1][j] != 9) {
            basinSize(map, i+1, j, index);
        }
    }
}

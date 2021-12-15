package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day15 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day15.txt")));
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/test.txt")));
        Day15 day15 = new Day15();
        day15.solution(test);
    }

    private void solution(ArrayList<String> input) {
        int[][] map = makeMap(input);
        doStep(map,0,0);
    }

    private void doStep(int[][] map,int i,int j){
        if(i == map.length-1 || j == map[0].length-1){
            if(i == map.length-1 && j == map[0].length-1){
                return;
            }
            return;
        }

        int[][] coppy = map.clone();
        coppy[i+1][j] += coppy[i][j];
        coppy[i][j+1] += coppy[i][j];
        doStep(coppy,i+1,j);
        doStep(coppy,i,j+1);
    }

    private int[][] makeMap(ArrayList<String> input){
        int[][] map = new int[input.size()][input.get(0).length()];
        int i =0;
        for(String s : input){
            int j =0;
            for(char c: s.toCharArray()){
                map[i][j++] = Integer.parseInt(""+c);
            }
            i++;
        }
        return map;
    }
}

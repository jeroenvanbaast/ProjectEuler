package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.lang.Math.max;

public class Problem67 {

    public static void main(String[] args) throws IOException {
        Problem67 p = new Problem67();
        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Path.of("src/files/triangle.txt")));
        p.solutionBruteForce(p.triangle(lines));
    }

    private void solutionBruteForce(ArrayList<ArrayList<Integer>> tri) {
        for (int j = 1; j < tri.size(); j++) {
            int i = 0;
            for (Integer n : tri.get(j)) {
                int p1 = 0;
                int p2 = 0;
                if (i != 0) {
                    p1 = tri.get(j - 1).get(i - 1);
                }
                if (i != tri.get(j - 1).size()) {
                    p2 = tri.get(j - 1).get(i);
                }
                int p = max(p1, p2);
                tri.get(j).set(i, n + p);
                i++;
            }
        }
        int solution =0;
        for(Integer i : tri.get(tri.size()-1)){
            solution = Math.max(i,solution);
        }
        System.out.println("Solution: " + tri.get(tri.size()-1).stream().max((a,b) -> a-b).get());
    }

    private ArrayList<ArrayList<Integer>> triangle(ArrayList<String> lines){
        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
        for(String line: lines){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (String c : line.split(" ")) {
                tmp.add(Integer.valueOf(c));
            }
            toReturn.add(tmp);
        }
        return toReturn;
    }
}
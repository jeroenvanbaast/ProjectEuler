package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day5 {

    public static void main(String[] args) throws IOException {
        Day5 d = new Day5();
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/test.txt")));
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/day5.txt")));
        d.solution(input, 1000);
    }

    private void solution(ArrayList<String> list, int n) {
        int[][] field = new int[n][n];
        for (String line : list) {
            int a = Integer.parseInt(line.substring(0, line.indexOf(",")));
            int b = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf(" ")));
            int c = Integer.parseInt(line.substring(line.indexOf("->") + 3, line.lastIndexOf(",")));
            int d = Integer.parseInt(line.substring(line.lastIndexOf(",") + 1));
            String row = "" +a+","+b + ","+c+","+d;
            if (a == c) {
                int x = 0;
                for (int i = Math.min(b, d); i < Math.max(b, d) + 1; i++) {
                    field[a][i] = field[a][i] + 1;
                    row += " "+a+","+i;
                    x = i;
                }
                if(a+x != c+d && a+x !=a+b){
                    System.out.println("Problem");
                }
            } else if (b == d) {
                int x =0;
                for (int i = Math.min(a, c); i < Math.max(a, c) + 1; i++) {
                    field[i][b] = field[i][b] + 1;
                    row += " "+i+b;
                    x=i;
                }
                if(b+x != c+d && b+x !=a+b){
                    System.out.println("Problem");
                }
            } else if (a < c && b < d) {
                int j = b;
                int x =0;
                for (int i = Math.min(a, c); i < Math.max(a, c) + 1; i++) {
                    row += " "+i+j;
                    field[i][j] = field[i][j++] + 1;
                    x=i;
                }
                if(--j+x != c+d && j+x !=a+b){
                    System.out.println("Problem");
                }
            } else if(a > c && b > d){
                int j = b;
                int x =0;
                for (int i = Math.max(a, c); i > Math.min(a, c)-1; i--) {
                    row += " "+i+j;
                    field[i][j] = field[i][j--] + 1;
                    x=i;
                }
                if(++j+x != c+d && j+x !=a+b){
                    System.out.println("Problem");
                }
            }else if (a < c && d < b) {
                int j = b;
                int x=0;
                for (int i = Math.min(a, c); i < Math.max(a, c) + 1; i++) {
                    row += " "+i+j;
                    field[i][j] = field[i][j--] + 1;
                    x=i;
                }
                if(++j+x != c+d && j+x !=a+b){
                    System.out.println("Problem");
                }
            } else if (c < a && b < d) {
                int j = a;
                int x =0;
                for (int i = Math.min(b, d); i < Math.max(b, d) + 1; i++) {
                    row += " "+j +"-"+i;
                    field[j][i] = field[j--][i] + 1;
                    x=i;
                }
                if(++j+x != c+d && j+x !=a+b){
                    System.out.println("Problem");
                }
            } else {
                System.out.println("Ignored: " + a + " " + b + " " + c + " " + d);
            }
            System.out.println(row);
        }
        output(field);
    }

    private void output(int[][] field) {
        int count = 0;
        for (int[] line : field) {
            String a = "";
            for (int cell : line) {
                a += cell + " ";
                if (cell > 1) {
                    count++;
                }
            }
//            System.out.println(a);
        }
        System.out.println("Solution: " + count);
    }
}

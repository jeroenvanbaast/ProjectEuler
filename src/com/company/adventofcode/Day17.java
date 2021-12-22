package com.company.adventofcode;

import java.io.IOException;
import java.util.HashSet;

public class Day17 {

    public static void main(String[] args) throws IOException {
        String input = "target area: x=79..137, y=-176..-117";
        Day17 day = new Day17();
        day.solution(input);
        day.bruteForce(input);
    }

    private void solution(String target) {
        int maxY = Integer.parseInt(target.substring(target.indexOf("y=") + 2, target.lastIndexOf("..")));
        int higestY = (maxY + 1) * -1;
        int sol = 0;
        for (int i = 0; i <= higestY; i++) {
            sol += i;
        }
        System.out.println("Solution1: " + sol);
    }

    private void bruteForce(String target) {
        int minX = Integer.parseInt(target.substring(target.indexOf("x=") + 2, target.indexOf("..")));
        int maxX = Integer.parseInt(target.substring(target.indexOf("..") + 2, target.indexOf(",")));
        int maxY = Integer.parseInt(target.substring(target.indexOf("y=") + 2, target.lastIndexOf("..")));
        int minY = Integer.parseInt(target.substring(target.lastIndexOf("..") + 2));
        HashSet<String> answers = new HashSet<>();

        for (int i =-5; i < 800; i++) {
            for (int j = 800; j > -800; j--) {
                int x = i;
                int y = j;
                int newX = 0;
                int newY = 0;
                while (true) {
                    newX += x;
                    newY += y;
                    if (x != 0) {
                        x--;
                    }
                    y--;
                    if (newX >= minX && newX <= maxX && newY <= minY && newY >= maxY) {
                        answers.add(i + "," + j);
                    } else if (newX > maxX || newY < maxY) {
                        break;
                    }
                }
            }
        }
        System.out.println("Solution2: " + answers.size());
    }

}

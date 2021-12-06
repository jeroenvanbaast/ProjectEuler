package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Day4 {

    public static void main(String[] args) throws IOException {
        int[] numbers = new int[]{7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1};
        int[] actualNumbers = new int[]{76, 69, 38, 62, 33, 48, 81, 2, 64, 21, 80, 90, 29, 99, 37, 15, 93, 46, 75, 0, 89, 56, 58, 40, 92, 47, 8, 6, 54, 96, 12, 66, 83, 4, 70, 19, 17, 5, 50, 52, 45, 51, 18, 27, 49, 71, 28, 86, 74, 77, 11, 20, 84, 72, 23, 31, 16, 78, 91, 65, 87, 79, 73, 94, 24, 68, 63, 9, 88, 82, 30, 42, 60, 13, 67, 85, 44, 59, 7, 53, 22, 1, 26, 41, 61, 55, 43, 39, 3, 35, 25, 34, 57, 10, 14, 32, 97, 95, 36, 98};
        ArrayList<String> a = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/day4.txt")));
        ArrayList<String> t = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/test.txt")));
        Day4 d = new Day4();
        ArrayList<ArrayList<ArrayList<Integer>>> cards = new ArrayList<>();
        d.makeCards(a);
        d.solution(actualNumbers, a);
//        d.solution(numbers, t);
    }

    private void solution(int[] numbers, ArrayList<String> a) {
        int[][][] cards = makeCards(a);
        boolean[] cardsDone = new boolean[cards.length];
        int bingoCount = 0;
        for (int num : numbers) {
            for (int i = 0; i < cards.length; i++) {
                if (!cardsDone[i]) {
                    cards[i] = markDown(cards[i], num);
                    if (bingo(cards[i])) {
                        cardsDone[i] = true;
                        bingoCount++;
                        if (bingoCount == cards.length) {
                            System.out.println("Bingo on: " + calc(cards[i], num));
                            return;
                        }
                    }
                }
            }
        }
    }

    private int calc(int[][] card, int number) {
        int count = 0;
        for (int[] row : card) {
            for (int cell : row) {
                if (cell != -1) {
                    count += cell;
                }
            }
        }
        return count * number;
    }

    private boolean bingo(int[][] card) {
        int[] cCount = new int[5];
        for (int i = 0; i < card.length; i++) {
            int rCount = 0;
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == -1) {
                    rCount++;
                    cCount[j] += 1;
                }
            }
            if (rCount == 5) {
                return true;
            }
        }
        for (int col : cCount) {
            if (col == 5) {
                return true;
            }
        }
        return false;
    }

    private int[][] markDown(int[][] card, int number) {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == number) {
                    card[i][j] = -1;
                }
            }
        }
        return card;
    }

    private int[][][] makeCards(ArrayList<String> a) {
        int[][][] cards = new int[(a.size() + 1) / 6][5][5];
        int i = 0;
        int j = 0;
        for (String s : a) {
            if (i != 0 && i % 5 == 0) {
                i = 0;
                j++;
                continue;
            }
            String[] test = s.split(" ");
            cards[j][i] = Arrays.stream(test).filter(q -> !q.isEmpty()).mapToInt(Integer::parseInt).toArray();
            i++;
        }
        return cards;
    }

    private void printCard(int[][] card) {
        for (int[] row : card) {
            String line = "";
            for (int cell : row) {
                line += "\t" + cell;
            }
            System.out.println(line);
        }
        System.out.println(" ");

    }
}

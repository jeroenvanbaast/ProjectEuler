package com.company.adventofcode;

import java.util.ArrayList;

public class Day21 {

    ArrayList<Integer> dieRolls = new ArrayList<>();
    int lastRoll = 0;

    public static void main(String[] args) {
        Day21 day21 = new Day21();
        for (int i = 1; i < 101; i++) {
            day21.dieRolls.add(i);
        }
        day21.solution(2,10);
    }

    private void solution(int p1Start, int p2Start) {
        int p1Pos = p1Start;
        int p2Pos = p2Start;
        int p1Points = 0;
        int p2Points = 0;
        int dieRollCount =0;
        while (true) {
            // p1 turn
            int rolled = rollDie(3);
            dieRollCount+=3;
            p1Pos += rolled;
            while (p1Pos > 10) {
                p1Pos -= 10;
            }
            p1Points+= p1Pos;
            if(p1Points > 999){
                System.out.println("Solution: " + (p2Points*dieRollCount));
                break;
            }

            //p2 turn
            int rolled2 = rollDie(3);
            dieRollCount+=3;
            p2Pos += rolled2;
            while (p2Pos > 10) {
                p2Pos -= 10;
            }
            p2Points+= p2Pos;
            if(p2Points > 999){
                System.out.println("Solution: " + (p1Points*dieRollCount));
                break;
            }
        }

    }

    private int rollDie(int times) {
        int total = 0;
        for (int i = 0; i < times; i++) {
            if(lastRoll == 100){
                lastRoll =0;
            }
            total += ++lastRoll;
        }
        return total;
    }


}

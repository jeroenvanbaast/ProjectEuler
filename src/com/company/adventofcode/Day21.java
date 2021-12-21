package com.company.adventofcode;

import java.util.HashMap;

public class Day21 {

    Long p1Wins = 0L;
    Long p2Wins = 0L;

    public static void main(String[] args) {
        Day21 day21 = new Day21();
        GameState g1 = new GameState(4, 8, 0, 0);
        HashMap<GameState, Integer> gameStateCount = new HashMap<>();
        gameStateCount.put(g1, 1);
        day21.solution(gameStateCount);
    }

    private void solution(HashMap<GameState, Integer> gameStateCount) {
        System.out.println(gameStateCount.values().stream().mapToInt(Integer::intValue).sum() + p1Wins + p2Wins);
        System.out.println(p1Wins + " " + p2Wins);
        HashMap<GameState, Integer> coppy = new HashMap<>();
        for (GameState gS : gameStateCount.keySet()) {
            for (int i = 1; i <= 3; i++) {
                for (int ii = 1; ii <= 3; ii++) {
                    for (int iii = 1; iii <= 3; iii++) {
                        GameState gameState = new GameState(gS.p1Pos, gS.p2Pos, gS.p1Points, gS.p2Points);
                        // p1 turn
                        int rolled = i + ii + iii;
                        gameState.p1Pos += rolled;
                        while (gameState.p1Pos > 10) {
                            gameState.p1Pos -= 10;
                        }
                        gameState.p1Points += gameState.p1Pos;
                        if (gameState.p1Points > 20) {
                            p1Wins += gameStateCount.get(gS);
                            continue;
                        }
                        for (int j = 1; j <= 3; j++) {
                            for (int jj = 1; jj <= 3; jj++) {
                                for (int jjj = 1; jjj <= 3; jjj++) {
                                    gameState = new GameState(gameState.p1Pos, gS.p2Pos, gameState.p1Points, gS.p2Points);
                                    //p2 turn
                                    int rolled2 = j + jj + jjj;
                                    gameState.p2Pos += rolled2;
                                    while (gameState.p2Pos > 10) {
                                        gameState.p2Pos -= 10;
                                    }
                                    gameState.p2Points += gameState.p2Pos;
                                    if (gameState.p2Points > 20) {
                                        p2Wins += gameStateCount.get(gS);
                                        break;
                                    }
                                    int toAdd = gameStateCount.get(gS);
                                    if (coppy.containsKey(gameState)) {
                                        coppy.put(gameState, coppy.get(gameState) + toAdd);
                                    } else {
                                        coppy.put(gameState, toAdd);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        if (coppy.isEmpty()) {
            System.out.println(p1Wins + " " + p2Wins);
        } else {
            if (p1Wins >= 444356092776315L) {
                System.out.println("Lets check");
            }
            solution(coppy);
        }
    }


    private static class GameState {
        int p1Pos = 0;
        int p2Pos = 0;
        int p1Points = 0;
        int p2Points = 0;

        public GameState(int p1Pos, int p2Pos, int p1Points, int p2Points) {
            this.p1Pos = p1Pos;
            this.p2Pos = p2Pos;
            this.p2Points = p2Points;
            this.p1Points = p1Points;
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }

        @Override
        public int hashCode() {
            String test = p1Points +"2"+ p2Points + p1Pos  +"5"+ p2Pos;
            return Integer.parseInt(test);
        }

    }
}

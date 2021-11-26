package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Problem54 {

    public static void main(String[] args) {
        Problem54 p = new Problem54();
        p.solution();
    }

    private void solution() {
        try {
            int count = 0;
            ArrayList<String> t = new ArrayList<>(Files.readAllLines(Path.of("src/files/poker.txt")));
            for (String s : t) {
                String p1 = s.substring(0, 14);
                String p2 = s.substring(15);
                if (p1Wins(p1, p2)) {
                    count++;
                }
            }
            System.out.println("Solution: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean p1Wins(String p1, String p2) {
        String s1 = valueOfHand(p1);
        String s2 = valueOfHand(p2);

        int h1 = convert(s1.replaceAll("\\d",""));
        int h2 = convert(s2.replaceAll("\\d",""));
        if (h1 == h2) {
            int high1 = Integer.parseInt(s1.replaceAll("[a-zA-Z]","").trim());
            int high2 = Integer.parseInt(s2.replaceAll("[a-zA-Z]","").trim());
            return high1 > high2;
        }
        return h1 > h2;
    }

    private int convert(String value) {
        switch (value) {
            case "One pair":
                return 1;
            case "Two pair":
                return 2;
            case "Three of a kind":
                return 3;
            case "Straight":
                return 4;
            case "Flush":
                return 5;
            case "Full house":
                return 6;
            case "Four of a kind":
                return 7;
            case "Straight Flush":
                return 8;
            case "Royal Flush":
                return 9;
        }
        return 0;
    }

    private String valueOfHand(String hand) {
        boolean flush = true;
        String firstSuit = hand.substring(1, 2);
        HashMap<Integer, Integer> cards = new HashMap<>();
        int highCard = 0;
        for (String card : hand.split(" ")) {
            String suit = card.substring(1);
            if (flush) {
                flush = suit.equals(firstSuit);
            }

            String value = card.substring(0, 1);
            if (value.matches("[a-zA-Z]")) {
                value = value.equals("T") ? "10" : value;
                value = value.equals("J") ? "11" : value;
                value = value.equals("Q") ? "12" : value;
                value = value.equals("K") ? "13" : value;
                value = value.equals("A") ? "14" : value;
            }
            int v = Integer.valueOf(value);
            int tmp = cards.getOrDefault(v, 0);
            cards.put(v, ++tmp);
            highCard = Math.max(highCard, v);
        }
        int pairs = 0;
        int threes = 0;
        int four = 0;
        int pairOf = 0;
        TreeSet<Integer> straightCheck = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : cards.entrySet()) {
            int v = entry.getValue();
            if (v == 2) {
                pairs++;
                pairOf = entry.getKey();
            } else if (v == 3) {
                threes++;
            } else if (v == 4) {
                four++;
            }
            straightCheck.add(entry.getKey());
        }
        Boolean straight = true;
        int last = 0;
        for (Integer s : straightCheck) {
            if (last != 0 && last + 1 != s) {
                straight = false;
            }
            last = s;
        }
        String returnValue = "";
        if (flush) {
            if (straight) {
                if (last == 14) {
                    returnValue = "Royal Flush";
                } else {
                    returnValue = "Straight Flush" + last;
                }
            } else {
                returnValue = "Flush";
            }
        } else if (straight) {
            returnValue = "Straight" + last;
        }
        if (pairs == 1) {
            if (threes == 1) {
                returnValue = "Full house";
            } else {
                returnValue = "One pair" + pairOf;
            }
        } else if (pairs == 2) {
            returnValue = "Two pair";
        } else if (threes == 1) {
            returnValue = "Three of a kind";
        } else if (four == 1) {
            returnValue = "Four of a kind";
        }
        if (returnValue.isEmpty()) {
            returnValue = "Highcard" + highCard;
        }
        return returnValue;
    }
}

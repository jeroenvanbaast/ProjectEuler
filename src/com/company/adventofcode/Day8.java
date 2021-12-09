package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day8 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/test.txt")));
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("D:\\officeplanner\\ProjectEuler\\src\\com\\company\\adventofcode/day8.txt")));
        Day8 day = new Day8();
        day.solution(input);
    }

    private void solution(ArrayList<String> input) {
        long ans =0;
        for (String s : input) {
            char[] display = new char[7];
            String[] digits = new String[10];
            String a = s.split("\\|")[0].strip();
            ArrayList<String> sixDigits = new ArrayList<>();
            ArrayList<String> fiveDigits = new ArrayList<>();
            for (String digit : a.split(" ")) {
                if (digit.length() == 2) {
                    digits[1] = digit;
                } else if (digit.length() == 3) {
                    digits[7] = digit;
                } else if (digit.length() == 4) {
                    digits[4] = digit;
                } else if (digit.length() == 7) {
                    digits[8] = digit;
                } else if (digit.length() == 6) {
                    sixDigits.add(digit);
                } else if (digit.length() == 5) {
                    fiveDigits.add(digit);
                }
            }
            display[0] = findDifference(digits[7], digits[1]);
            // Finds the digit that misses one of the 2 letters from 1 this has to be 6
            // With this information we can place both the letters of 1 on the display.
            outer : for (int i =0; i<2; i++) {
                char d = digits[1].toCharArray()[i];
                for (String x : sixDigits) {
                    if(!stringHasChar(x,d)){
                        digits[6] = x;
                        display[2] = d;
                        if(i ==0){
                            display[5] = digits[1].toCharArray()[1];
                        }else{
                            display[5] = digits[1].toCharArray()[0];
                        }
                        sixDigits.remove(x);
                        break outer;
                    }
                }
            }
            // the 0 and 9 using the 4. 9 contains the entire 4 while 0 misses one of the lines.
            outer :for (int i =0; i<4; i++) {
                char d = digits[4].toCharArray()[i];
                for (String x : sixDigits) {
                    if(!stringHasChar(x,d)){
                        digits[0] = x;
                        display[3] = d;
                        sixDigits.remove(x);
                        break outer;
                    }
                }
            }
            digits[9] = sixDigits.get(0);
            display[4] = findDifference(digits[8], digits[9]);
            // fills display line 1 with the only not found line from the letters in 4.
            for(char c : digits[4].toCharArray()){
                if(c!= display[2] && c!= display[3] && c!= display[5]){
                    display[1]  =c;
                    break;
                }
            }
            // fills last display line.
            outer : for(char c: digits[8].toCharArray()){
                for(char ch : display){
                    if(c == ch){
                        continue outer;
                    }
                }
                display[6] = c;
            }
            for(String d: fiveDigits){
                if(!stringHasChar(d,display[2])){
                    digits[5] =d;
                }else if(stringHasChar(d,display[4])){
                    digits[2] = d;
                }else{
                    digits[3] = d;
                }
            }
            String output = "";
            for(String b : s.split("\\|")[1].strip().split(" ")){
                for(int i =0; i < digits.length; i++){
                    String digit = digits[i];
                    if(isDigit(b,digit)){
                        output+=i;
                    }
                }
            }
            ans += Long.valueOf(output);
        }
        System.out.println("Solution: " + ans);
    }

    private boolean isDigit(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        for(char c : a.toCharArray()){
            if(!stringHasChar(b,c)){
                return false;
            }
        }
        return true;
    }

    private char findDifference(String a, String b) {
        outer:
        for (char c : a.toCharArray()) {
            for (char c2 : b.toCharArray()) {
                if (c == c2) {
                    continue outer;
                }
            }
            return c;
        }
        return 0;
    }

    private boolean stringHasChar(String s, char c){
        for(char ch: s.toCharArray()){
            if(ch == c){
                return true;
            }
        }
        return false;
    }
}

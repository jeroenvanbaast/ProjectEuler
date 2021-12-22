package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day18 {

    HashSet<Long> answers = new HashSet<>();
    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day18.txt")));
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/test.txt")));
        Day18 day18 = new Day18();
        day18.part2(input);
    }

    private void part2(ArrayList<String> input){
        for(int i =0; i < input.size(); i++){
            for(int j =0; j< input.size(); j++){
                if(i!=j){
                    solution(new ArrayList<>(List.of(new String[]{input.get(i), input.get(j)})));
                }
            }
        }
        System.out.println("Solution 2: " + answers.stream().mapToLong(Long::longValue).max().getAsLong());
    }

    private void calcMagnitude(String input) {
        String next = input;
        for (int i = 0; i < input.length() - 4; i++) {
            String test =  input.substring(i);
            int asdf = test.indexOf("]");
            String part = input.substring(i, test.indexOf("]")+i+1);
            if (part.matches("\\[[0-9]*,[0-9]*]")) {
                int a = Integer.parseInt(part.substring(part.indexOf("[")+1, part.indexOf(",")));
                int b = Integer.parseInt(part.substring(part.indexOf(",")+1, part.indexOf("]")));
                Long ans = a * 3L + b * 2L;
                next = next.replace(part, String.valueOf(ans));
            }
        }
        if (input.contains("[")) {
            calcMagnitude(next);
        } else {
            System.out.println(next);
            answers.add(Long.parseLong(next));
        }
    }

    private void solution(ArrayList<String> input) {
        String a = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            a = "[" + a + "," + input.get(i) + "]";
            String lastA = "";
            while (!a.equals(lastA)) {
                lastA = a;
                a = explode(a);
                if (lastA.equals(a)) {
                    a = split(a);
                }
            }
        }
        calcMagnitude(a);
    }

    private String split(String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            String s = input.substring(i, i + 2);
            if (s.matches("[0-9][0-9]")) {
                int t = Integer.parseInt(s);
                int a = t / 2;
                int b = t / 2;
                b = (a + b) == t ? b : b + 1;
                return input.substring(0, i) + "[" + a + "," + b + "]" + input.substring(i + 2);
            }
        }
        return input;
    }

    private String explode(String input) {
        int open = 0;
        int closed = 0;
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == '[') {
                open++;
            } else if (input.charAt(i) == ']') {
                closed++;
            } else if (open > closed + 4 && input.substring(i, i + 3).matches("[0-9],[0-9]")) {
                int a = 0;
                int b = 0;
                boolean beenInA = false;
                boolean beenInB = false;
                int xDigits = 1;
                if (input.substring(0, i - 1).matches(".*\\d.*")) {
                    int j = findLastIndex(input.substring(0, i - 1));
                    xDigits = input.substring(j, j + 2).matches("[0-9][0-9]") ? 2 : 1;
                    String x = input.substring(j, j + xDigits);
                    if (input.substring(j - 1, j + 1).matches("[0-9][0-9]") && !input.substring(j, j + 2).matches("[0-9][0-9]")) {
                        x = input.substring(j - 1, j + 1);
                        xDigits = 2;
                    }
                    int yStart = input.substring(i - 1, i + 1).matches("[0-9][0-9]") ? -1 : 0;
                    String y = input.substring(i + yStart, i + 1);
                    beenInA = true;
                    a = Integer.parseInt(x) + Integer.parseInt(y);
                }
                if (input.substring(i + 4).matches(".*\\d.*")) {
                    int j = findFirstIndex(input.substring(i + 4)) + i + 4;
                    xDigits = input.substring(j, j + 2).matches("[0-9][0-9]") ? 2 : 1;
                    String x = input.substring(j, j + xDigits);
                    int yEnd = input.substring(i + 2, i + 4).matches("[0-9][0-9]") ? 4 : 3;
                    String y = input.substring(i + 2, i + yEnd);
                    beenInB = true;
                    b = Integer.parseInt(x) + Integer.parseInt(y);
                }
                if (!beenInA) {
                    int j = findFirstIndex(input.substring(i + 4)) + i + 4;
                    input = input.substring(0, j) + b + input.substring(j + xDigits);
//                    input = input.substring(0, i - 1) + "0" + input.substring(i + 4);
                } else if (!beenInB) {
                    int k = findLastIndex(input.substring(0, i - 1));
                    input = input.substring(0, k) + a + input.substring(k + 1);
//                    input = input.substring(0, i - tmp) + "0" + input.substring(i + 4);
                } else {
                    int j = findFirstIndex(input.substring(i + 4)) + i + 4;
                    int k = findLastIndex(input.substring(0, i - 1));
                    String startA = input.substring(k - 1, k).matches("[0-9]") ? input.substring(0, k - 1) : input.substring(0, k);
                    input = input.substring(0, j) + b + input.substring(j + xDigits);
                    input = startA + a + input.substring(k + 1);
                }
                input = input.substring(0, input.substring(0, i + 2).lastIndexOf("[")) + input.substring(i + input.substring(i + 1).indexOf("]") + 2);
                int ind = input.indexOf("[,");
                if (ind > 0) {
                    input = input.substring(0, ind + 1) + "0" + input.substring(ind + 1);
                }
                ind = input.indexOf(",]");
                if (ind > 0) {
                    input = input.substring(0, ind + 1) + "0" + input.substring(ind + 1);
                }
                return input;
            }


        }
        return input;
    }

    private int findFirstIndex(String input) {
        for (char c : input.toCharArray()) {
            String s = "" + c;
            if (s.matches("[0-9]")) {
                return input.indexOf("" + c);
            }
        }
        return -1;
    }

    private int findLastIndex(String input) {
        for (char c : new StringBuilder(input).reverse().toString().toCharArray()) {
            String s = "" + c;
            if (s.matches("[0-9]")) {
                return input.lastIndexOf("" + c);
            }
        }
        return -1;
    }

    private void testExplode(ArrayList<String> input) {
        String a = explode("[[[[[9,8],1],2],3],4]");
        System.out.println(a.equals("[[[[0,9],2],3],4]"));
        System.out.println("[[[[[9,8],1],2],3],4]" + "   " + a);

        String b = explode("[7,[6,[5,[4,[3,2]]]]]");
        System.out.println(b.equals("[7,[6,[5,[7,0]]]]"));
        System.out.println("[7,[6,[5,[4,[3,2]]]]]" + "   " + b);

        String c = explode("[[6,[5,[4,[3,2]]]],1]");
        System.out.println(c.equals("[[6,[5,[7,0]]],3]"));
        System.out.println("[[6,[5,[4,[3,2]]]],1]" + "   " + c);

        String d = explode("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]");
        System.out.println(d.equals("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]"));
        System.out.println("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]" + "   " + d);

        String e = explode("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]");
        System.out.println(e.equals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]"));
        System.out.println("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]" + "   " + e);

        String f = explode("[[[[0,7],4],[7,[[8,4],9]]],[1,1]]");
        System.out.println(f.equals("[[[[0,7],4],[15,[0,13]]],[1,1]]"));
        System.out.println("[[[[0,7],4],[7,[[8,4],9]]],[1,1]]" + "   " + f);

        String g = explode("[[[[4,0],[5,4]],[[7,0],[15,5]]],[10,[[0,[11,3]],[[6,3],[8,8]]]]]");
        System.out.println(g.equals("[[[[4,0],[5,4]],[[7,0],[15,5]]],[10,[[11,0],[[9,3],[8,8]]]]]"));
        System.out.println("[[[[4,0],[5,4]],[[7,0],[15,5]]],[10,[[0,[11,3]],[[6,3],[8,8]]]]]" + "   " + g);
    }
}

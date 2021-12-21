package com.company.adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day20 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/day20.txt")));
        ArrayList<String> test = new ArrayList<>(Files.readAllLines(Path.of("src/com/company/adventofcode/test.txt")));
        Day20 day20 = new Day20();
        day20.solution(input);
    }

    private void solution(ArrayList<String> input) {
        List<String> enhancements = enhancement(input);
        boolean[][] image = image(input);
        for (int i = 0; i < 50; i++) {
            image = enhance(image, enhancements, true);
        }
        draw(image, true);
        System.out.println("Solution: " + countLit(image));
    }

    private boolean[][] enhance(boolean[][] image, List<String> enhancements, boolean realInput) {
        boolean[][] enhancedImage = new boolean[image.length][image[0].length];
        for (int i = 1; i < image.length - 1; i++) {
            for (int j = 1; j < image[i].length - 1; j++) {
                boolean[] row1 = {image[i - 1][j - 1], image[i - 1][j], image[i - 1][j + 1]};
                boolean[] row2 = {image[i][j - 1], image[i][j], image[i][j + 1]};
                boolean[] row3 = {image[i + 1][j - 1], image[i + 1][j], image[i + 1][j + 1]};
                ArrayList<String> drawing = draw(new boolean[][]{row1, row2, row3}, false);
                String numb = "";
                for (String line : drawing) {
                    numb += line;
                }
                numb = numb.replaceAll("#", "1");
                numb = numb.replaceAll("\\.", "0");
                int pixel = Integer.parseInt(numb, 2);
                enhancedImage[i][j] = enhancements.get(pixel).equals("#");
            }
        }
        if (realInput) {
            boolean toFill = enhancedImage[2][2];
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[i].length; j++) {
                    if (i == 0 || i == image.length-1) {
                        enhancedImage[i][j] = toFill;
                    }
                    if(j ==0 || j == image.length-1){
                        enhancedImage[i][j] = toFill;
                    }
                }
            }
        }
        return enhancedImage;
    }

    private boolean[][] image(ArrayList<String> input) {
        ArrayList<String> first = new ArrayList<>();
        boolean whasEMpty = false;
        for (String s : input) {
            if (whasEMpty) {
                first.add(s);
            }
            if (s.isEmpty()) {
                whasEMpty = true;
            }
        }
        int size = first.get(0).length() * 3;
        int toAdd = size / 3;
        boolean[][] toReturn = new boolean[size][size];
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < first.get(0).length(); j++) {
                toReturn[toAdd + i][toAdd + j] = first.get(i).charAt(j) == '#';
            }
        }
        return toReturn;
    }

    private List<String> enhancement(ArrayList<String> input) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (String s : input) {
            if (s.isEmpty()) {
                break;
            }
            for (Character c : s.toCharArray()) {
                toReturn.add("" + c);
            }
        }
        return toReturn;
    }

    private ArrayList<String> draw(boolean[][] image, boolean draw) {
        ArrayList<String> drawing = new ArrayList<>();
        for (boolean[] row : image) {
            String line = "";
            for (boolean cell : row) {
                line += cell ? "#" : ".";
            }
            drawing.add(line);
            if (draw) {
                System.out.println(line);
            }
        }
        return drawing;
    }

    private int countLit(boolean[][] image) {
        int sum = 0;
        for (boolean[] row : image) {
            for (boolean cell : row) {
                sum += cell ? 1 : 0;
            }
        }
        return sum;
    }
}

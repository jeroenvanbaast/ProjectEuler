package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem42 {

    private static List<String> abc = Arrays.asList(IntStream.rangeClosed('A', 'Z')
            .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).split("(?!^)"));

    private final HashSet<Integer> tirangles = generate();

    public static void main(String[] args) {
        Problem42 p = new Problem42();
        p.solution();
    }


    public void solution() {
        try {
            int count = 0;
            ArrayList<String> t = new ArrayList<>(Files.readAllLines(Path.of("src/files/words.txt")));
            List<String> words = Arrays.asList(t.get(0).split(","));
            for(String word: words){
                word = word.replaceAll("\"", "");
                if(tirangles.contains(getValue(word))){
                    count++;
                }
            }
            System.out.println("Solution: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getValue(String word){
        int ans =0;
        for(char c : word.toCharArray()){
            int i = abc.indexOf(""+c)+1;
            ans += i;
        }
        return ans;
    }

    public HashSet<Integer> generate(){
        HashSet<Integer> toReturn = new HashSet<>();
        for(int i = 0; i<=20; i++){
            toReturn.add((int) (0.5 * i *(i+1)));
        }
        return toReturn;
    }
}

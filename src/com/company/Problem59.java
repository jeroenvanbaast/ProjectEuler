package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem59 {

    public static void main(String[] args) throws IOException {
        List<Integer> t = Files.readAllLines(Path.of("src/files/cipher.txt"))
                .stream()
                .flatMap(str -> Arrays.stream(str.split(",")))
                .map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Problem59 p = new Problem59();
        p.solution(t);
    }

    // Start with Hello > 72,101,108,108,111
    // key = uBV,; > 117,66,86,44,59
    // chiper = =':@T > 61,39,58,64,84
    private void solution(List<Integer> list) {
        for (int i = 97; i < 122; i++) {
            for (int j = 97; j < 122; j++) {
                for (int k = 97; k < 122; k++) {
                    String ans = tryKey(list,i,j,k);
                    if (ans.contains(" the ")) {
                        System.out.println("Tekst: " + ans);
                        long count =0;
                        for(char c : ans.toCharArray()){
                            count += (int) c;
                        }
                        System.out.println("Solution: " + count);
                        System.out.println("Key: " +((char) i)  + ((char)j) +  ((char)k));
                    }
                }
            }
        }
    }

    private String tryKey(List<Integer> list, int i, int j, int k){
        String s ="";
        for(int a =0; a< list.size(); a+=3){
            int node1 = list.get(a) ^i;
            int node2 = list.get(a+1) ^j;
            int node3 = list.get(a+2) ^k;
            char c1 = (char) node1;
            char c2 = (char) node2;
            char c3 = (char) node3;
            s += "" + c1 + "" + c2 + "" + c3;
        }
        return s;
    }
}


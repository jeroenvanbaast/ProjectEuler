package com.company;

import java.math.BigInteger;
import java.util.*;

public class Problem62 {

    HashMap<Integer, ArrayList<BigInteger>> cubes = new HashMap<>();
    HashSet<BigInteger> permutations = new HashSet<>();

    public static void main(String[] args) {
        Problem62 p = new Problem62();
        p.solution();
    }

    private void solution() {
        cubes = calcCubes(10_000);
        for (Map.Entry<Integer, ArrayList<BigInteger>> k : cubes.entrySet()) {
            for (BigInteger cube : k.getValue()) {
                if(cube.equals(BigInteger.valueOf(41063625))){
                    int a =3;
                }
                int count =0;
                for (BigInteger i : k.getValue()) {
                    if (isPermute(cube,i)) {
                        count++;
                    }
                }
                if (count == 4) {
                    System.out.println(cube);
                }
            }
        }
    }

    private boolean isPermute(BigInteger x, BigInteger y){
        if(x.equals(y)){
            return false;
        }
        char[] a = x.toString().toCharArray();
        char[] b = y.toString().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i =0; i< a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    private void permute(String value, String toPut) {
        if (toPut.length() == 0) {
            if (!value.startsWith("0")) {
                permutations.add(BigInteger.valueOf(Long.parseLong(value)));
            }
            return;
        }
        String tmp = toPut;
        for (char c : toPut.toCharArray()) {
            permute(value + c, tmp.replaceFirst("" + c, ""));
        }
    }

    private HashMap<Integer, ArrayList<BigInteger>> calcCubes(int n) {
        HashMap<Integer, ArrayList<BigInteger>> toReturn = new HashMap<>();
        for (int i = 0; i < n; i++) {
            BigInteger a = BigInteger.valueOf(i).pow(3);
            int key = String.valueOf(a).length();
            if (!toReturn.containsKey(key)) {
                toReturn.put(key, new ArrayList<>());
            }
            toReturn.get(key).add(a);
        }
        return toReturn;
    }
}

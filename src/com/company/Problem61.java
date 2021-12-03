package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Problem61 {
    ArrayList<Integer> triangles = triangles();
    ArrayList<Integer> squares = squares();
    ArrayList<Integer> pentagonal = pentagonal();
    ArrayList<Integer> hexagonal = hexagonal();
    ArrayList<Integer> heptagonal = heptagonal();

    HashMap<String, ArrayList<String>> all = new HashMap();

    public static void main(String[] args) {
        Problem61 p = new Problem61();
        p.fill();
        for (int i : p.octagonal()) {
            String soFar = String.valueOf(i);
            p.solution(soFar);
        }
    }

    private void solution(String soFar) {
        if (soFar.length() == 4 * 6) {
            if (soFar.substring(0, 2).equals(soFar.substring(soFar.length() - 2))) {
                output(soFar);
            }
            return;
        }
        String key = soFar.substring(soFar.length() - 2);
        if (!all.containsKey(key)) {
            return;
        }
        for (String s : all.get(key)) {
            solution(soFar + s);
        }
    }

    private boolean check(ArrayList<Integer> a) {
        HashMap<String, ArrayList<Integer>> test = new HashMap<>();
        test.put("tri", new ArrayList<>());
        test.put("sq", new ArrayList<>());
        test.put("pent", new ArrayList<>());
        test.put("hex", new ArrayList<>());
        test.put("hept", new ArrayList<>());
        HashSet<Integer> set = new HashSet<>();
        a.remove(0);
        for (int i : a) {
            set.add(i);
            if (triangles.contains(i)) {
                test.get("tri").add(i);
            }
            if (squares.contains(i)) {
                test.get("sq").add(i);
            }
            if (pentagonal.contains(i)) {
                test.get("pent").add(i);
            }
            if (hexagonal.contains(i)) {
                test.get("hex").add(i);
            }
            if (heptagonal.contains(i)) {
                test.get("hept").add(i);
            }
        }
        if (set.size() == 5) {
            for(ArrayList<Integer> list : test.values()){
                if(list.size() ==0){
                    return false;
                }else if (list.size() == 1){
                    continue;
                }else{
                    boolean first = false;
                    for(int i : list){
                        int count =0;
                        if (triangles.contains(i)) {
                            count++;
                        }
                        if (squares.contains(i)) {
                            count++;
                        }
                        if (pentagonal.contains(i)) {
                            count++;
                        }
                        if (hexagonal.contains(i)) {
                            count++;
                        }
                        if (heptagonal.contains(i)) {
                            count++;
                        }
                        if(count ==1){
                            if(first){
                                return false;
                            }
                            first = true;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

//    private boolean check(ArrayList<Integer> a) {
//        boolean tri = false;
//        boolean sq = false;
//        boolean pent = false;
//        boolean hex = false;
//        boolean hept = false;
//        HashSet<Integer> set = new HashSet<>();
//        for (int i : a) {
//            set.add(i);
//            if (triangles.contains(i)) {
//                tri = true;
//            }
//            if (squares.contains(i)) {
//                sq = true;
//            }
//            if (pentagonal.contains(i)) {
//                pent = true;
//            }
//            if (hexagonal.contains(i)) {
//                hex = true;
//            }
//            if (heptagonal.contains(i)) {
//                hept = true;
//            }
//        }
//        return tri && sq && pent && hex && hept && set.size()==6;
//    }

    private void output(String s) {
        for (int i = 4; i < s.length(); i += 5) {
            s = s.substring(0, i) + " " + s.substring(i);
        }
        int sum = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for (String a : s.split(" ")) {
            int b = Integer.valueOf(a);
            sum += b;
            nums.add(b);
        }
        if (check(nums)) {
            System.out.println(s + " Sum: " + sum);
        }
    }

    private void fillALlWith(ArrayList<Integer> numbers) {
        for (int i : numbers) {
            String a = String.valueOf(i);
            String key = a.substring(0, 2);
            if (all.containsKey(key)) {
                all.get(key).add(a);
            } else {
                all.put(key, new ArrayList<String>(Collections.singleton(a)));
            }
        }
    }

    private ArrayList<Integer> triangles() {
        ArrayList<Integer> triangles = new ArrayList<>();
        int n = 1;
        int a = 0;
        while (a < 10_000) {
            a = n * (n + 1) / 2;
            n++;
            if (a > 999 && 10_000 > a) {
                triangles.add(a);
            }
        }
        return triangles;
    }

    private ArrayList<Integer> squares() {
        ArrayList<Integer> squares = new ArrayList<>();
        int n = 1;
        int a = 0;
        while (a < 10_000) {
            a = n * n;
            n++;
            if (a > 999 && 10_000 > a) {
                squares.add(a);
            }
        }
        return squares;
    }

    private ArrayList<Integer> pentagonal() {
        ArrayList<Integer> pentagonal = new ArrayList<>();
        int n = 1;
        int a = 0;
        while (a < 10_000) {
            a = n * (3 * n - 1) / 2;
            n++;
            if (a > 999 && 10_000 > a) {
                pentagonal.add(a);
            }
        }
        return pentagonal;
    }

    private ArrayList<Integer> hexagonal() {
        ArrayList<Integer> hexagonal = new ArrayList<>();
        int n = 1;
        int a = 0;
        while (a < 10_000) {
            a = n * (2 * n - 1);
            n++;
            if (a > 999 && 10_000 > a) {
                hexagonal.add(a);
            }
        }
        return hexagonal;
    }

    private ArrayList<Integer> heptagonal() {
        ArrayList<Integer> heptagonal = new ArrayList<>();
        int n = 1;
        int a = 0;
        while (a < 10_000) {
            a = n * (5 * n - 3) / 2;
            n++;
            if (a > 999 && 10_000 > a) {
                heptagonal.add(a);
            }
        }
        return heptagonal;
    }

    private ArrayList<Integer> octagonal() {
        ArrayList<Integer> octagonal = new ArrayList<>();
        int n = 1;
        int a = 0;
        while (a < 10_000) {
            a = n * (3 * n - 2);
            n++;
            if (a > 999 && 10_000 > a) {
                octagonal.add(a);
            }
        }
        return octagonal;
    }

    private void fill() {
        fillALlWith(triangles);
        fillALlWith(squares);
        fillALlWith(pentagonal);
        fillALlWith(hexagonal);
        fillALlWith(heptagonal);
    }
}

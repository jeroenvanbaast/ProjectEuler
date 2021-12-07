package com.company.adventofcode;

import java.util.*;

public class Day6 {

    public static void main(String[] args) {
        Day6 day = new Day6();
        List<Integer> test = new ArrayList<>(Arrays.asList(3, 4, 3, 1, 2));
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 5, 5, 2, 1, 3, 1, 4, 3, 2, 1, 5, 5, 1, 2, 3, 4, 4, 1, 2, 3, 2, 1, 4, 4, 1, 5, 5, 1, 3, 4, 4, 4, 1, 2, 2, 5, 1, 5, 5, 3, 2, 3, 1, 1, 3, 5, 1, 1, 2, 4, 2, 3, 1, 1, 2, 1, 3, 1, 2, 1, 1, 2, 1, 2, 2, 1, 1, 1, 1, 5, 4, 5, 2, 1, 3, 2, 4, 1, 1, 3, 4, 1, 4, 1, 5, 1, 4, 1, 5, 3, 2, 3, 2, 2, 4, 4, 3, 3, 4, 3, 4, 4, 3, 4, 5, 1, 2, 5, 2, 1, 5, 5, 1, 3, 4, 2, 2, 4, 2, 2, 1, 3, 2, 5, 5, 1, 3, 3, 4, 3, 5, 3, 5, 5, 4, 5, 1, 1, 4, 1, 4, 5, 1, 1, 1, 4, 1, 1, 4, 2, 1, 4, 1, 3, 4, 4, 3, 1, 2, 2, 4, 3, 3, 2, 2, 2, 3, 5, 5, 2, 3, 1, 5, 1, 1, 1, 1, 3, 1, 4, 1, 4, 1, 2, 5, 3, 2, 4, 4, 1, 3, 1, 1, 1, 3, 4, 4, 1, 1, 2, 1, 4, 3, 4, 2, 2, 3, 2, 4, 3, 1, 5, 1, 3, 1, 4, 5, 5, 3, 5, 1, 3, 5, 5, 4, 2, 3, 2, 4, 1, 3, 2, 2, 2, 1, 3, 4, 2, 5, 2, 5, 3, 5, 5, 1, 1, 1, 2, 2, 3, 1, 4, 4, 4, 5, 4, 5, 5, 1, 4, 5, 5, 4, 1, 1, 5, 3, 3, 1, 4, 1, 3, 1, 1, 4, 1, 5, 2, 3, 2, 3, 1, 2, 2, 2, 1, 1, 5, 1, 4, 5, 2, 4, 2, 2, 3));
        day.test(day.createMap(list), 256);
    }

    private HashMap<Long, Long> createMap(List<Integer> list) {
        HashMap<Long, Long> map = new HashMap<>();
        for (Integer j : list) {
            Long i = (long)j;
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1L);
            }
        }
        return map;
    }

    private void test(HashMap<Long, Long> map, int days) {
        if (days == 0) {
            System.out.println("Solution: " + map.values().stream().mapToLong(a->a).sum());
            return;
        }
        HashMap<Long, Long> coppy = new HashMap<>();
        for (Map.Entry<Long, Long> e : map.entrySet()) {
            Long key = e.getKey();
            if (key == 0L) {
                coppy.put(8L, e.getValue());
                if (coppy.containsKey(6L)) {
                    coppy.put(6L, coppy.get(6L) + e.getValue());
                } else {
                    coppy.put(6L, e.getValue());
                }
            } else if (map.containsKey(key)) {
                if (coppy.containsKey(key-1)) {
                    coppy.put(key - 1, coppy.get(key-1) + e.getValue());
                }else{
                    coppy.put(key - 1, e.getValue());

                }
            }
        }
        test(coppy, days - 1);
    }
}

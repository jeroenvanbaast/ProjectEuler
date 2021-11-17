package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Problem26 {

    public static void main(String... args) {
        Problem26 p = new Problem26();
        System.out.println(p.findSequence(p.a(10000)));
//        System.out.println(p.findSequence(new ArrayList<BigDecimal>(List.of(new BigDecimal[]{BigDecimal.ONE.divide(BigDecimal.valueOf(2), 2000, RoundingMode.HALF_UP)}))));
    }

    public int findSequence(ArrayList<BigDecimal> k) {
        int toReturn = 0;
        int i = 2;
        for (BigDecimal a : k) {
            System.out.println("Nr: "  +a);

            String b = a.toString();
            int ii = 2;
            while (true) {
                ii++;
                String part = b.substring(i,ii);
                if(b.lastIndexOf(part) <= ii){
                    System.out.println("no sequince");
                    break;
                }//                System.out.println(part);
                if (test(b, part)) {
                    System.out.println(part.length());
                    if (toReturn < part.length()) {
                        toReturn = part.length();
                    }
                    break;
                } else if (false) {
                    break;
                }
            }
        }
        return toReturn;
    }


    public boolean test(String whole, String part) {
        StringBuilder tmp = new StringBuilder();
        while (tmp.length() < whole.length()-10) {
            tmp.append(part);
        }
        if (whole.contains(tmp.toString())) {
            return true;
        }
        return false;
    }

    public ArrayList<BigDecimal> a(int q) {
        ArrayList<BigDecimal> toReturn = new ArrayList<>();
        for (int i = 1; i < q; i++) {
            toReturn.add(BigDecimal.ONE.divide(BigDecimal.valueOf(i), 2000, RoundingMode.HALF_UP));
        }
        return toReturn;
    }
}

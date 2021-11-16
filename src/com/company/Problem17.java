package com.company;

public class Problem17 {

    public static void main(String... args) {
        Problem17 p = new Problem17();
        System.out.println(p.solution());
    }

    public int solution() {
        StringBuilder x = new StringBuilder();
        for (String f : firstDigit) {
            for (String s : secondDigit) {
                if (s.equals(" ten")) {
                    for (String l : tenNames) {
                        x.append(f).append(l);
                    }
                } else {
                    for (String l : lastDigit) {
                        x.append(f).append(s).append(l);
                    }
                }
            }
        }
        String y = x.toString().replaceAll("\\s+","");
        System.out.println(x.toString());
        // THe 9*3 are the ands from one hunderd and two hunderd and so forth
        return y.strip().length()- (9*3) +11;
    }
    public static final String[] firstDigit = {
            "",
            "one hundred and",
            "two hundred and",
            "three hundred and",
            "four hundred and",
            "five hundred and",
            "six hundred and",
            "seven hundred and",
            "eight hundred and",
            "nine hundred and",
    };

    public static final String[] secondDigit = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    public static final String[] lastDigit = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
    };

    public static final String[] tenNames = {
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };
}

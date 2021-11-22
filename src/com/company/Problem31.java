package com.company;

public class Problem31 {

    int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};

    public static void main(String... args) {
        Problem31 p = new Problem31();
        p.solution(200);
    }

    public void solution(int a) {
        int count = 1;
        for (int oneHundred = 0; oneHundred <= a / 100; oneHundred++) {
            for (int fifty = 0; fifty <= a / 50; fifty++) {
                for (int twenty = 0; twenty <= a / 20; twenty++) {
                    for (int ten = 0; ten <= a / 10; ten++) {
                        for (int five = 0; five <= a / 5; five++) {
                            for (int two = 0; two <= a / 2; two++) {
                                for (int one = 0; one <= a; one++) {
                                    int sum = oneHundred * 100 + fifty * 50 + twenty * 20 + ten * 10 + five * 5 + two * 2 + one;
                                    if (sum == 200) {
                                        count++;
                                        break;
                                    } else if (sum > 200) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}

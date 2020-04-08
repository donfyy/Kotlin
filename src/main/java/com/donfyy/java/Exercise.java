package com.donfyy.java;

public class Exercise {
    public static void printContinuousSequence(int number) {
        if (number < 3) {
            return;
        }

        int small = 1;
        int big = 2;
        int curSum = 3;

        int middle = (number + 1) / 2;
        while (small < middle) {
            if (curSum == number) {
                printContinuousSequence_(small, big);
            }

            while (curSum > number && small < middle) {
                curSum -= small;
                ++small;

                if (curSum == number) {
                    printContinuousSequence_(small, big);
                }
            }

            ++big;
            curSum += big;
        }
    }

    public static void main(String... args) {
        printContinuousSequence(3);
    }

    private static void printContinuousSequence_(int small, int big) {
        StringBuilder builder = new StringBuilder();
        for (int i = small; i <= big; i++) {
            builder.append(i);
        }
        System.out.println(builder);
    }
}

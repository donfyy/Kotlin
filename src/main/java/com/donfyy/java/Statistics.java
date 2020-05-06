package com.donfyy.java;

import java.io.*;
import java.util.Arrays;

public class Statistics {

    public static void main(String... args) {
        File x = new File("./test");

        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(x);
            bufferedReader = new BufferedReader(fileReader);

            int allLineSum = 0;
            int testedLineSum = 0;
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                if (s.length > 0) {
                    String s1 = s[s.length - 1];
                    String substring = s1.substring(1, s1.length() - 1);
                    String[] split = substring.split("/");


                    testedLineSum += Integer.parseInt(split[0]);
                    allLineSum += Integer.parseInt(split[1]);
                }

                line = bufferedReader.readLine();
            }

            System.out.println("tested:" + testedLineSum + " all:" + allLineSum);

            System.out.println("coverage:" + (1.0 * testedLineSum / allLineSum));
        } catch (Exception e) {
            e.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

package com.donfyy.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String... args) {
        ArrayList<Object> objects = new ArrayList<>();
        List<Object> filteredList = objects.stream().filter(o -> {
            return o.equals("abc");
        }).collect(Collectors.toList());

        Integer a = 1;
        Long b = 1L;

        System.out.println(a.equals(b));

        int[] array = new int[3];


        String[] split = "  a  b".split("\\s+");
        for (String s : split) {
            System.out.println("|" + s + "|");
        }

        System.out.println(firstCapOnly1("  a  b", true));

        assert findeCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}) == 3;
        assert findeCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}) == 1;
    }


    private static String firstCapOnly1( String str, boolean isRemoveSeparator) {
        if (str == null) {
            return "";
        }
        str = str.trim();
        if (str.length() == 0) {
            return "";
        }

        if (str.length() == 1) {
            return str.toUpperCase();
        }
        String[] splits = str.toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String eachWord = splits[i];
            if (!isRemoveSeparator && i > 0 && eachWord.length() > 0) {
                sb.append(" ");
            }
            String cap = eachWord.substring(0, 1).toUpperCase()
                    + eachWord.substring(1);
            sb.append(cap);
        }
        return sb.toString();
    }

    public static int findeCircleNum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        boolean[] visited = new boolean[matrix.length];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (dfs(matrix, visited, i) > 0) {
                count++;
            }
        }

        return count;

    }

    private static int dfs(int[][] matrix, boolean[] visited, int i) {
        if (visited[i]) {
            return 0;
        }

        visited[i] = true;
        int count = 1;
        for (int j = 0; j < visited.length; j++) {
            if (i != j && matrix[i][j] == 1) {
                count += dfs(matrix, visited, i);
            }
        }
        return count;
    }
}

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
    }
}

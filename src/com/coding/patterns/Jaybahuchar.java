package com.coding.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Jaybahuchar {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4,6,7,9,10};
        IntStream.of(numbers).boxed().collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<String, Integer>();

        System.out.println("abcdefghijklmnopqrstuvwxyz".compareTo("~"));
    }
}

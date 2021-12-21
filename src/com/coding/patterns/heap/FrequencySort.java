package com.coding.patterns.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String sortByFrequency(String str) {
        // return empty string if input is empty
        if (str == null || str.length() == 0) {
            return str;
        }

        // sort by frequency
        Map<Character, Integer> characterFrequency = new HashMap<>();
        // O(Length of String)
        for(char ch : str.toCharArray()) {
            characterFrequency.put(ch, characterFrequency.getOrDefault(ch, 0) + 1);
        }

        // maxHeap of character
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // Add characterFrequency to maxHeap
        // O(N * logN)
        maxHeap.addAll(characterFrequency.entrySet());

        StringBuilder newString = new StringBuilder(str.length());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            int i = Integer.valueOf(entry.getValue());
            while (i > 0) {
                newString.append(entry.getKey());
                i--;
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        String result = sortByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = sortByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}

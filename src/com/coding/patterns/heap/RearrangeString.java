package com.coding.patterns.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
    public static String rearrangeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // 1. Create a charFrequencyMap
        // O(len(str))
        for (char c : str.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        // 2. Create a MaxHeap to poll max frequency char all the times
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        // 3. Store all Map Entries to PQ
        // O(N * log N)
        for (Map.Entry<Character, Integer> entry: charFrequencyMap.entrySet()) {
            maxHeap.add(entry);
        }

        // 4. Let's poll max frequency char and store to put it back in next run
        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();

            if (previous != null && previous.getValue() > 0) {
                maxHeap.add(previous);
            }

            result.append(current.getKey());
            current.setValue(current.getValue() - 1);
            previous = current;
        }
        return result.toString().length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}

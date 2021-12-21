package com.coding.patterns.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * LeetCode Problem: https://leetcode.com/problems/reorganize-string/
 *
 * Pattern: Use Heap
 */
public class ReOrganizeString {
    public static String reorganizeString(String s) {
        if (s.isEmpty()) return s;

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            maxHeap.add(entry);
        }

        String result = "";
        Map.Entry<Character,Integer> previous = null;
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            result += entry.getKey();
            entry.setValue(entry.getValue() - 1);
            if(previous != null && previous.getValue() > 0 && previous.getKey() != entry.getKey()) {
                maxHeap.add(previous);
            }
            previous = entry;
        }

        return s.length() == result.length() ? result : "";
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab").isEmpty());
    }
}

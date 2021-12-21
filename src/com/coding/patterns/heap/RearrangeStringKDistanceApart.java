package com.coding.patterns.heap;

import java.util.*;

/**
 * LeetCode Pattern: Top 'k' pattern
 * Problem: https://leetcode.com/problems/rearrange-string-k-distance-apart/
 */
public class RearrangeStringKDistanceApart {
    public static String rearrangeStringKDistance(String str, int k) {
        // 1 - Add base case
        if (k <= 1) {
            return str;
        }

        // 2- Create HashMap, PQ, Queue
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) ->
                b.getValue() - a.getValue());
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        // 3 - Add all characters to maxHeap
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Add all characters to Heap
        maxHeap.addAll(map.entrySet());

        // 4 - Run an algorithm
        StringBuilder result = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            result.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            queue.offer(entry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry1 = queue.poll();
                if (entry1.getValue() > 0) {
                    maxHeap.add(entry1);
                }
            }
        }
        return result.toString().length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(rearrangeStringKDistance("mpmp", 2));
        System.out.println(rearrangeStringKDistance("Programming", 3));
        System.out.println(rearrangeStringKDistance("aab", 2));
        System.out.println(rearrangeStringKDistance("aapa", 3));
    }
}

package com.coding.patterns.heap;

import java.util.*;

public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        if (k == nums.length) {
            return new ArrayList<>();
        }
        // find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (int n: nums) {
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() -
                e2.getValue());

        // go through all numbers of map & push them in a minHeap which will have top k elements
        // If at any time it has > K elements, then remove the smallest element.

        for(Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Let's create a list of top k elements
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }

    public static void main(String[] args) {
        //List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        //System.out.println("Here are the K frequent numbers: " + result);

        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] {1,1,1,2,2 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}

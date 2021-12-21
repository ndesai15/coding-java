package com.coding.patterns.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem: https://www.educative.io/courses/grokking-the-coding-interview/gx6oKY8PGYY
 */
public class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinctElementCount = 0;
        if (nums.length <= k) {
            return distinctElementCount;
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (e1, e2) -> e1.getValue() - e2.getValue());

        // find frequency of each number
        Map<Integer, Integer> numFrequencyCount = new HashMap<>();
        // O(N)
        for(int i:nums) {
            numFrequencyCount.put(i, numFrequencyCount.getOrDefault(i, 0) + 1);
        }

        /*
            [7, 3, 5, 8, 5, 3, 3], k = 2

            {
              3 -> 3,
              5 -> 2,
              7 -> 1
            }
         */
        // O(N*logN)
        for (Map.Entry<Integer,Integer> entry: numFrequencyCount.entrySet()) {
            if (entry.getValue() == 1) {
                distinctElementCount++;
            }
            else {

                /*
                    MinHeap:
                    5 -> 2
                    3 -> 3
                 */
                minHeap.add(entry);
            }
        }

        // O(K * logN)
        while (!minHeap.isEmpty() && k >0) {
            if(minHeap.peek().getValue() == 1) {
                minHeap.poll();
                distinctElementCount++;
            }
            else {
                k--;
                minHeap.peek().setValue(minHeap.peek().getValue() - 1);
            }
        }

        // O(k)
        while (k > 0) {
           distinctElementCount--;
           k--;
        }

        return distinctElementCount;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}

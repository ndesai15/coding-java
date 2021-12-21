package com.coding.patterns.heap;

import java.util.PriorityQueue;

public class SumOfElements {
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        if (nums.length == 0 || nums == null || nums.length > k1 || nums.length > k2) {
            return 0;
        }

        // Create a minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        // Add all numbers to minheap
        // Time complexity : O(N logN)
        for (int n: nums) {
            minHeap.add(n);
        }

        // Remove first k1 elements
        int i = 0;
        // Time complexity : O(k1 logk1)
        while (i < k1 && !minHeap.isEmpty()) {
            minHeap.poll();
            i++;
        }

        int j = 0;
        int sum = 0;
        // Time complexity : O(M logM)
        while (j < k2 - k1 - 1 && !minHeap.isEmpty()) {
            sum += minHeap.poll();
        }

        return sum;
    }
}

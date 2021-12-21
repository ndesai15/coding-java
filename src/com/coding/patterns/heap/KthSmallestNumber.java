package com.coding.patterns.heap;

import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k) {
        // Define Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // O(K*logK) time
        // Add k elements from nums to heap
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        // O((N-K)*logK) times
        // Iterate over remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        // O(1) time
        return maxHeap.peek();
    }
}

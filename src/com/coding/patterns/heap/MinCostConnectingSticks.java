package com.coding.patterns.heap;

import java.util.PriorityQueue;

/**
 * Leetcode problem: https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */

/*
     Time Complexity: O(N*logN)
     Space Complexity: O(N)
 */
public class MinCostConnectingSticks {
    public int connectSticks(int[] sticks) {
        // Create a minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a- b);
        // O(NlogN)
        for (int i = 0; i < sticks.length; i++) {
            minHeap.add(sticks[i]);
        }

        int result = 0, temp = 0;
        while (minHeap.size() > 1) {
            temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }

        return result;
    }
}

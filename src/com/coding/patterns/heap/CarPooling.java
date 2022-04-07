package com.coding.patterns.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode Problem: https://leetcode.com/problems/car-pooling/
 */

// Time Complexity: O(N * LogN)
// Space Complexity: O(N)
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int curPass = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); // Pair stored in minHeap(endLocation Number, numOfPass)
        for (int[] trip: trips) {
            int numOfPassengers = trip[0], start = trip[1], end = trip[2];

            while(!minHeap.isEmpty() && minHeap.peek()[0] <= start) {
                curPass -= minHeap.peek()[1];
                minHeap.poll();
            }

            curPass += numOfPassengers;
            if (curPass > capacity) return false;
            minHeap.add(new int[]{end, numOfPassengers});
        }
        return true;
    }
}

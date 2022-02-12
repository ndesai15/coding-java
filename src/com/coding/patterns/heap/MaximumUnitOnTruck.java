package com.coding.patterns.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode problem: https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class MaximumUnitOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);

        // O(N)
        maxHeap.addAll(Arrays.asList(boxTypes));

        int result = 0;
        // O(N * logN)
        while(!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int boxCount = Math.min(truckSize, top[0]);
            result += boxCount * top[1];
            truckSize -= boxCount;
            if (truckSize == 0) break;
        }
        return result;
    }
}

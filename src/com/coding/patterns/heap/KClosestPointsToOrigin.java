package com.coding.patterns.heap;

import java.util.PriorityQueue;

/**
 * LeetCode problem: https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    public static int[][] findClosestPoints(int[][] points, int k) {

        PriorityQueue<int[]> distHeap = new PriorityQueue<>((a, b) ->
                (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        // Add first k points to heap
        // O(K * logK) time
        for (int i = 0 ; i < k; i++) {
            distHeap.add(points[i]);
        }

        // compare remaining elements
        // O((N-K) * logK) time
        for(int i = k; i < points.length; i++) {
            int[] currentPoint = points[i];
            int currentDist = currentPoint[0] * currentPoint[0] + currentPoint[1] * currentPoint[1];
            int[] peekElement = distHeap.peek();
            int heapPointDist = peekElement[0] * peekElement[0] + peekElement[1] * peekElement[1];
            if (currentDist < heapPointDist) {
                distHeap.poll();
                distHeap.add(currentPoint);
            }
        }

        // Next we create an array to contain points up to K
        int[][] results = new int[k][2];

        // Then iterate and add elements from our minHeap up to K
        for (int i = 0; i < k; i++) {
            results[i] = distHeap.poll();
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] points = { {1, 3}, {3, 4}, {2, -1}};
        int[][] result = findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (int[] point : result)
            System.out.print("[" + point[0] + " , " + point[1] + "] ");
    }
}

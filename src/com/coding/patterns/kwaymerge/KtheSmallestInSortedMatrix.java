package com.coding.patterns.kwaymerge;

import java.util.PriorityQueue;

/**
 * Pattern: K-way merge
 * Leetcode problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
class MatrixPair {
    int elementIndex;
    int rowIndex;

    public MatrixPair(int elementIndex, int rowIndex) {
        this.elementIndex = elementIndex;
        this.rowIndex = rowIndex;
    }
}
public class KtheSmallestInSortedMatrix {
    public static int findKthSmallest(int[][] matrix, int k) {
        // k way merge pattern
        // Create a Heap, MinHeap will be useful here
        PriorityQueue<MatrixPair> minHeap = new PriorityQueue<MatrixPair>(
                (a, b) -> matrix[a.rowIndex][a.elementIndex] - matrix[b.rowIndex][b.elementIndex]
        );

        // Add the first element of each row to minHeap
        // O(N)
        for (int i = 0 ; i < matrix.length; i++) {
            minHeap.add(new MatrixPair(0,i));
        }
        int result = 0;
        while (!minHeap.isEmpty()) {
            MatrixPair pair = minHeap.poll();
            result = matrix[pair.rowIndex][pair.elementIndex];
            k--;
            if (k == 0) {
                break;
            }
            pair.elementIndex++;
            // O(k*logN)
            if(matrix[pair.rowIndex].length > pair.elementIndex) {
                minHeap.add(pair);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}

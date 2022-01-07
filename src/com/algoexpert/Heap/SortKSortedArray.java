package com.algoexpert.Heap;

import java.util.PriorityQueue;

// Time Complexity: O(N * logK)
// Space Complexity: O(k)
public class SortKSortedArray {
    public static int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        int sortedIdx = 0;
        int min = Math.min(k + 1, array.length);
        for (int i = 0; i < min; i++) {
            minHeap.add(array[i]);
        }

        for (int i = k + 1; i < array.length; i++) {
            array[sortedIdx++] = minHeap.poll();
            minHeap.add(array[i]);
        }

        while (!minHeap.isEmpty()) {
            array[sortedIdx++] = minHeap.poll();
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, -100};
        int[] result = sortKSortedArray(array, 5);
        for (int i: result) {
            System.out.print(i + ", ");
        }
    }
}

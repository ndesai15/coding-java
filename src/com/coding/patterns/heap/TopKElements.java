package com.coding.patterns.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {
    public static List<Integer> topKElements(int[] nums, int K) {
        // Define a Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

        // insert first K elements from nums
        for (int i = 0; i < K; i++) {
            minHeap.add(nums[i]);
        }

        // Perform comparison against rest of the other elements in nums
        for (int i = K; i < nums.length; i++) {
            if(minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = topKElements(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = topKElements(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}

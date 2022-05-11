package com.coding.patterns.heap;

import java.util.PriorityQueue;

public class KThLargestInStream {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KThLargestInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>((a , b) -> a - b);
        for(int num: nums) {
            minHeap.add(num);
        }
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

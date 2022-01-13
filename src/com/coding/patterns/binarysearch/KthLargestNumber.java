package com.coding.patterns.binarysearch;

import java.util.PriorityQueue;

public class KthLargestNumber {
    public String kthLargestNumber(String[] nums, int k) {
        int length = nums.length;
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.length() == b.length())
                return a.compareTo(b);
            else
                return Integer.compare(a.length(), b.length());
        });
        for (String num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}

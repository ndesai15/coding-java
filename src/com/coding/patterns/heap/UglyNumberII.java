package com.coding.patterns.heap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {
    private static int[] allowedPrime = {2, 3, 5};
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        HashSet<Long> usedNumbers = new HashSet<>();
        minHeap.add(1L);
        usedNumbers.add(1L);
        for(int i = 1; i < n; i++) {
            long result = minHeap.poll();
            for(int prime : allowedPrime) {
                if (!usedNumbers.contains(result * prime)) {
                    minHeap.add(prime * result);
                    usedNumbers.add(prime * result);
                }
            }
        }
        return minHeap.poll().intValue();
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(5));
    }
}

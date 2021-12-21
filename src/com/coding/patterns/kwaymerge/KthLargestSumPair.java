package com.coding.patterns.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Pattern: K-way merge Pattern
 */
public class KthLargestSumPair {
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        // KWay merge pattern

        // Create a minHeap by sum of pair
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0 ; j < nums2.length && j < k; j++) {
                if (minHeap.size() < k) {
                    minHeap.add(new int[]{nums1[i], nums2[j]});
                }
                else  {
                    // start comparision with rest of the other elements of arrays
                    if (nums1[i] + nums2[j] < minHeap.peek()[0] + minHeap.peek()[1]) {
                        break;
                    }
                    else {
                        minHeap.poll();
                        minHeap.add(new int[] {nums1[i], nums2[j]});
                    }
                }
            }
        }
        return new ArrayList<>(minHeap);
    }
    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}

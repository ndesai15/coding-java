package com.coding.patterns.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Pattern: K-way merge
 * Leetcode: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 */
public class SmallestRange {
    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) ->
                lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);

        // add all the first element of arrays
        // get the currentMax number from stored numbers in Heap
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Pair(0,i));
                currentMax = Math.max(currentMax, lists.get(i)[0]);
            }
        }

        // Find out the smallest Range
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        // O(N * logK)
        while (minHeap.size() == lists.size()) {
            Pair element = minHeap.poll();
            if (rangeEnd - rangeStart > currentMax - lists.get(element.arrayIndex)[element.elementIndex]) {
                rangeEnd = currentMax;
                rangeStart = lists.get(element.arrayIndex)[element.elementIndex];
            }
            element.elementIndex++;
            if (lists.get(element.arrayIndex).length > element.elementIndex) {
                minHeap.add(element);
                currentMax = Math.max(currentMax, lists.get(element.arrayIndex)[element.elementIndex]);
            }
        }
        return new int[] {rangeStart , rangeEnd};
    }
}

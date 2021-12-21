package com.coding.patterns.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] findSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            }
            else {
                minHeap.add(nums[i]);
            }
            rebalanceHeaps();

            // check if sliding window == k or not
            if (i - k + 1 >= 0) {
                if (maxHeap.size() == minHeap.size()) {
                    // even numbers
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                }
                else {
                    // because max-heap will have one more element than the min-heap
                    result[i - k + 1] = maxHeap.peek();
                }

                // remove the element going out of sliding window
                int elementToBeRemove = nums[i-k+1];
                if(elementToBeRemove <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemove);
                }
                else {
                    minHeap.remove(elementToBeRemove);
                }
                rebalanceHeaps();
            }
        }
        return result;
    }

    private void rebalanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindow(new int[] {1, 2, -1, 3, 5 }, 2);

        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindow(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}

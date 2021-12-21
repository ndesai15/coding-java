package com.coding.patterns.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return nums;
        }
        int n = nums.length;

        // Base case
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];

        // Deque will store indices
        Deque<Integer> deque = new ArrayDeque<>();

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            // pop out smaller values from deque
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[windowEnd]){
                deque.removeLast();
            }

            deque.add(windowEnd);
            // remove left value from window
            if (windowStart > deque.getFirst()) {
                deque.removeFirst();
            }

            if (windowEnd - windowStart + 1 >= k) {
                result[windowStart] = nums[deque.getFirst()];
                windowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+", ");
        }
    }
}

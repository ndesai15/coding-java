package com.coding.patterns.slidingWindow;

/**
 * LeetCode problem: https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class MinSwapsGroupOnes {
    public static int minSwaps(int[] data) {
        int windowSize = 0;
        for (int n: data) windowSize+= n;
        int curOnesInWindow = 0, maxOnesInWindow = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < data.length; windowEnd++) {
            curOnesInWindow += data[windowEnd];
            if (windowEnd >= windowSize) {
                curOnesInWindow -= data[windowStart++];
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, curOnesInWindow);
        }
        return windowSize - maxOnesInWindow;
    }
}

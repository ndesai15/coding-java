package com.coding.patterns.arrays;


/**
 * LeetCode Problem: https://leetcode.com/problems/slowest-key/
 */

// Time Complexity: O(N), Space Complexity: O(1)
public class SlowestKeyProblem {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;

        // Let's consider first key as a slowest key and taking longestDuration
        char slowestKey = keysPressed.charAt(0);
        int longestDuration = releaseTimes[0];

        for (int i = 1; i < n; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i-1];
            if ((currentDuration > longestDuration) || ((currentDuration == longestDuration) && keysPressed.charAt(i) > slowestKey)) {
                slowestKey = keysPressed.charAt(i);
                longestDuration = currentDuration;
            }
        }
        return slowestKey;
    }
}

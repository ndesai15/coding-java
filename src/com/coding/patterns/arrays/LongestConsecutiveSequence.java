package com.coding.patterns.arrays;

import java.util.HashMap;

/**
 * LeetCode problem: https://leetcode.com/problems/longest-consecutive-sequence/
 */
// Time Complexity: O(N)
// Space Complexity: O(N)
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, true);
        }
        int longest = 0;

        for (int n: nums) {
            if (!map.get(n)) {
                continue;
            }
            map.put(n, false);
            int current = 1;
            int left = n - 1;
            int right = n + 1;
            while(map.containsKey(left)) {
                map.put(left, false);
                left--;
                current++;
            }
            while(map.containsKey(right)) {
                map.put(right, false);
                right++;
                current++;
            }
            if (current > longest){
                longest = current;
            }
        }
        return longest;
    }
}

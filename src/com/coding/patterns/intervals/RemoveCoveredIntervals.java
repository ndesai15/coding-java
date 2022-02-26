package com.coding.patterns.intervals;

import java.util.Arrays;
import java.util.Comparator;


/**
 * LeetCode Problem: https://leetcode.com/problems/remove-covered-intervals/
 */
// Time Complexity: O(N * logN)
// Space Complexity: O(N)
public class RemoveCoveredIntervals {
    public static int countOfUncoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int count = 1;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length;i++) {
            if (prevEnd < intervals[i][1]) {
                count++;
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}

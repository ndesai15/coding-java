package com.algoexpert.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Minimum%20Waiting%20Time
 */

// Time Complexity: O(N LogN)
// Space Complexity: O(1)
public class MinWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int total = 0;
        int n = queries.length;
        for (int i = 0 ; i < n; i++) {
            if (i == n - 1) continue;;
            total += queries[i] * (n - 1 - i);
        }
        return total;
    }
}

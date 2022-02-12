package com.algoexpert.Recursion;


/**
 * AlgoExpert problem: https://www.algoexpert.io/questions/Staircase%20Traversal
 */
// Time Complexity: O(N * K)
// Space Complexity; O(N)
public class StairCaseTraversal {
    public int stairCaseTraversal(int height, int maxSteps) {
        int[] dp = new int[height + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= height; i++) {
            int steps = 1, curr = 0;
            // O(K) -> K is # of steps
            while (steps <= maxSteps && steps <= i) {
                curr += dp[i-1];
                steps++;
            }
            dp[i] = curr;
        }
        return dp[height];
    }
}

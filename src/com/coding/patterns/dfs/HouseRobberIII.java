package com.coding.patterns.dfs;

/**
 * LeetCode problem: https://leetcode.com/problems/house-robber-iii/
 */
// Time Complexity: O(N)
public class HouseRobberIII {
    private static int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] leftPair = dfs(root.left);
        int[] rightPair = dfs(root.right);
        int withRoot = root.val + leftPair[1] + rightPair[1];
        int withOutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);
        return new int[]{withRoot, withOutRoot};
    }
    public static int findMax(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
}

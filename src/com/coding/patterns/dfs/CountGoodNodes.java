package com.coding.patterns.dfs;

/**
 * LeetCode problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Pattern : Depth First Search
 */
public class CountGoodNodes {
    private int goodNode = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodNode;
    }

    private void dfs(TreeNode node, int maxSoFar) {
        if (node.val >= maxSoFar) {
            goodNode++;
        }
        if (node.left != null) {
            dfs(node.left, Math.max(maxSoFar, node.val));
        }
        if (node.right != null) {
            dfs(node.right, Math.max(maxSoFar, node.val));
        }
    }
}

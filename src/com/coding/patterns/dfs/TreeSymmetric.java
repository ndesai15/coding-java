package com.coding.patterns.dfs;

/**
 * Pattern: DFS
 * LeetCode Problem: https://leetcode.com/problems/symmetric-tree/
 */
public class TreeSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isMirror(t1.left,t2.left) && isMirror(t1.right, t2.right);
    }
}
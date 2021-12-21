package com.coding.patterns.recursion;

/**
 * Leetcode problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Pattern: Recursion
 * Best video on recursion: https://www.youtube.com/watch?v=ngCos392W4w&ab_channel=Reducible
 */

public class InvertATree {
    public TreeNode invertTree(TreeNode root) {
        // if node is a null
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

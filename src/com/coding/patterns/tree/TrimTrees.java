package com.coding.patterns.tree;

/**
 * Pattern: Recursion on Trees
 * LeetCode Problem: https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class TrimTrees {
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root.val < low) {
            // Root is too low than given low so there is no meaning in searching left subtree of it.
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            // Root is too high than given high so there is no meaning in searching right subtree of it.
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}

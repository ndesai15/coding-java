package com.coding.patterns.tree;

public class BalancedBinaryTree {
    private static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = calculateHeight(root.left);
        int rightTreeHeight = calculateHeight(root.right);

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) <= 1 &&
                isBalance(root.right) && isBalance(root.left);
    }
}

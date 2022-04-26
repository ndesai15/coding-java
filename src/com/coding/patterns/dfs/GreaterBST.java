package com.coding.patterns.dfs;

/**
 * LeetCode Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/
 */

// Time Complexity: O(N)
// Space Complexity: O(H), H is the height of BST which should be logN for balanced tree
public class GreaterBST {
    private static int currentSum = 0;

    // Reverse Inorder traversal
    private static void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        int temp = node.val;
        node.val += currentSum;
        currentSum += temp;
        dfs(node.left);
    }

    public static TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
}

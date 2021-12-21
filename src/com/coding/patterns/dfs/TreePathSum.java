package com.coding.patterns.dfs;

/**
 * Coding Pattern: DFS Inorder Traversal
 * Problem link: https://www.educative.io/courses/grokking-the-coding-interview/RMlGwgpoKKY
 */
public class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;
        // if the current node is a leaf & current node's value == remaining sum, return true
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        // recursive search in left subtree & right subtree
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
    }
}

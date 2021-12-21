package com.coding.patterns.recursion;

/**
 * Leetcode problem: https://leetcode.com/problems/subtree-of-another-tree/
 * Pattern: Recursion
 * Best video on recursion: https://www.youtube.com/watch?v=ngCos392W4w&ab_channel=Reducible
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

 // Time Complexity : O(M *N)
public class IsASubTree {
    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        return isSameTree(root, subRoot) || isSubTree(root.left, subRoot) ||
                isSubTree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

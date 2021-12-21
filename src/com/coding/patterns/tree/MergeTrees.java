package com.coding.patterns.tree;

/**
 * LeetCode problem
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null && root2 != null) {
            return root2;
        }
        if (root1 != null && root2 == null) {
            return root1;
        }
        return new TreeNode(root1.val + root2.val, mergeTrees(root1.left, root2.left),
                mergeTrees(root1.right, root2.right));
    }
}

package com.coding.patterns.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem: https://leetcode.com/problems/find-leaves-of-binary-tree/
 */

// Time Complexity: O(N), N is the # nodes in a tree
// Space Complexity: O(N), N is the # nodes in a tree
public class RemoveLeavesOfTree {
    private static TreeNode removeLeaves(TreeNode root, List<Integer> current) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            current.add(root.val);
            return null;
        }

        root.left = removeLeaves(root.left, current);
        root.right = removeLeaves(root.right, current);
        return root;
    }
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        while (root != null) {
            List<Integer> temp = new ArrayList<>();
            root = removeLeaves(root, temp);
            result.add(temp);
        }
        return result;
    }
}

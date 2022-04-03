package com.coding.patterns.tree;

import java.util.Stack;

/**
 * LeetCode Problem: https://leetcode.com/problems/binary-search-tree-iterator/
 */

// Time Complexity: Average O(1)
// Space Complexity: O(h), h is the height of tree
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        TreeNode cur = top.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

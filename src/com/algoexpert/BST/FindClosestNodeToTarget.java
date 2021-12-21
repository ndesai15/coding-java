package com.algoexpert.BST;

import com.coding.patterns.tree.TreeNode;


/**
 * LeetCode Problem: https://leetcode.com/problems/closest-binary-search-tree-value/
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
 */
public class FindClosestNodeToTarget {
    public static int findClosestVal(TreeNode root, double target, int currentClosest) {
        if (root == null) {
            return currentClosest;
        }

        double currentDiff1 = Math.abs(target - root.val);
        double currentDiff2 = Math.abs(target - currentClosest);
        if (currentDiff1 == 0) {
            return root.val;
        }
        if (currentDiff1 < currentDiff2) {
            currentClosest = root.val;
        }
        if (root.val  <= target) {
            // right subtree
            return findClosestVal(root.right, target, currentClosest);
        }
        else {
            // left subtree
            return findClosestVal(root.left, target, currentClosest);
        }
    }
    public int closestValue(TreeNode root, double target) {
        return findClosestVal(root, target, root.val);
    }
}

package com.coding.patterns.bfs;

import java.util.*;

/**
 * Pattern: Tree Traversal : Breadth First Search(BFS)
 * Leetcode problem: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Groaking the Coding Interview: https://www.educative.io/courses/grokking-the-coding-interview/xV7E64m4lnz
 *
 */
public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            // Traverse only that specific level
            for (int i = 0; i < queueLength; i ++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}

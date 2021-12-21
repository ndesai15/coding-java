package com.coding.patterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Pattern: Tree Traversal : Breadth First Search(BFS)
 * Leetcode problem: ???
 * Groaking the Coding Interview:???
 *
 */
public class MaximumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            // Increment on every level change
            maxDepth++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode current = queue.remove();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Maximum Depth: " + findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Maximum Depth: " + findDepth(root));
    }
}

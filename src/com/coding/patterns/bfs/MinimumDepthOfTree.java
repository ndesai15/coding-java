package com.coding.patterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Pattern: Tree Traversal : Breadth First Search(BFS)
 * Leetcode problem: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Groaking the Coding Interview: https://www.educative.io/courses/grokking-the-coding-interview/3jwVx84OMkO
 */
public class MinimumDepthOfTree {
   public static int findDepth(TreeNode root) {
       if (root == null) {
           return 0;
       }
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);
       int minDepth = 0;
       while (!queue.isEmpty()) {
           minDepth++;
           int queueSize = queue.size();
           for (int i = 0; i < queueSize; i++) {
               TreeNode current = queue.remove();
               if(current.right == null && current.left == null) {
                   return minDepth;
               }
               if (current.left != null) {
                   queue.add(current.left);
               }
               if (current.right != null) {
                   queue.add(current.right);
               }
           }
       }
       return minDepth;
   }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
    }
}

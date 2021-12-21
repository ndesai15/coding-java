package com.coding.patterns.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean rightToLeft = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode current = queue.remove();
                if(rightToLeft) {
                    level.add(0,current.val);
                }
                else {
                    level.add(current.val);
                }
                if (current.left!= null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            rightToLeft = !rightToLeft;
            result.add(level);
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = zigzagTraversal(root);
        System.out.println("Zigzag traversal: " + result);
    }
}

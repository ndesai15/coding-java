package com.coding.patterns.tree;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallest {
    private ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);

        return arr;
    }
    public int kthSmallestRecursive(TreeNode root, int k) {
        ArrayList<Integer> inOrderList = inOrder(root, new ArrayList<>());
        return inOrderList.get(k-1);
    }

    public int KthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode current = root;

        while (current != null && !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // process the node
            current = stack.pop();
            count += 1;
            if (count == k) {
                return current.val;
            }
            current = current.right;
        }
        return 0;
    }
}

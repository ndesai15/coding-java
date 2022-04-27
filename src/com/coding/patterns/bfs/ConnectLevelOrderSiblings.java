package com.coding.patterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeNext {
    int val;
    TreeNodeNext left;
    TreeNodeNext right;
    TreeNodeNext next;

    TreeNodeNext(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        TreeNodeNext nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNodeNext current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class ConnectLevelOrderSiblings {
    public static void connect(TreeNodeNext root) {
        if (root == null){
            return;
        }
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNodeNext previous = null;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNodeNext current = queue.remove();
                if (previous != null) {
                    previous.next = current;
                }
                previous = current;

                // Iterate over left child
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    /**
     * LeetCode Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
     */
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    // NOTE: Following solution works better only for balanced binary tree
    public static void connectBetterForBalancedBinaryTree(TreeNodeNext root) {
       TreeNodeNext current = root;
       TreeNodeNext next = root == null ? null : root.left;

       while (current != null && next != null) {
           current.left.next = current.right;

           if (current.next != null) {
               current.right.next = current.next.left;
           }
           current = current.next;

           if (current == null) {
               current = next;
               next = current.left;
           }
       }
    }

    public static void main(String[] args) {
        TreeNodeNext root = new TreeNodeNext(12);
        root.left = new TreeNodeNext(7);
        root.right = new TreeNodeNext(1);
        root.left.left = new TreeNodeNext(9);
        root.right.left = new TreeNodeNext(10);
        root.right.right = new TreeNodeNext(5);
        connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}

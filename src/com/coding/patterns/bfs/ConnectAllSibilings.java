package com.coding.patterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSibilings {
    public static void connect(TreeNodeNext root) {
        if (root == null) {
            return;
        }
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);
        TreeNodeNext previous = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeNext current = queue.remove();
                if(previous != null) {
                    previous.next = current;
                }
                previous = current;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
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

        // level order traversal using 'next' pointer
        TreeNodeNext current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

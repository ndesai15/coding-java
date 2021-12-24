package com.coding.patterns.datastructures.linkedlists;

import com.coding.patterns.inplace.linkedlistInplace.ListNode;

public class SplitLinkedLists {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode current = root;
        while (current != null) {
            current = current.next;
            length++;
        }

        int parts = length / k;
        int rem = length % k;

        ListNode[] result = new ListNode[k];

        if (root == null) {
            return result;
        }

        current = root;
        for (int i = 0; i < k; i++) {
            ListNode head = current;

            for (int j = 0; j < parts + (i < rem ? 1 : 0) - 1; j++) {
                if (current != null) current = current.next;
            }
            if (current != null) {
                ListNode prev = current;
                current = current.next;
                prev.next = null;
            }
            result[i] = head;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = null;
        System.out.println(splitListToParts(node1, 3));
    }
}

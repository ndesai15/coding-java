package com.coding.patterns.linkedlists;

import java.util.Stack;

/**
 * LeetCode Problem: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
public class FlattenMultiLevelLinkedList {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;

        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

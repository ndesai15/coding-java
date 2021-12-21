package com.coding.patterns.linkedlistInplace;


public class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        if (rotations <= 0 || head == null) {
            return head;
        }

        // Get the length
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        ListNode current = head;
        rotations = rotations % length;
        if (rotations == 0) {
            return head;
        }
        for (int i = 0; i < length - rotations - 1; i++) {
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        tail.next = head;
        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

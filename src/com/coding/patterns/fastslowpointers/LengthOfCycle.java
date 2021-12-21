package com.coding.patterns.fastslowpointers;

public class LengthOfCycle {
    public static int lengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return calculateLength(slow);
            }
        }
        return -1;
    }

    private static int calculateLength(ListNode slow) {
        ListNode current = slow;
        int length = 0;
        do {
            length++;
            current = current.next;
        } while (current != slow);
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + lengthOfCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + lengthOfCycle(head));
    }
}

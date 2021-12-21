package com.coding.patterns.fastslowpointers;

/**
 * Pattern : Fast & Slow Pointers
 *
 */
public class RearrangeLinkedList {
    public static void reOrder(ListNode head) {
        if (head == null) return;

        ListNode fast = head;
        ListNode slow = head;

        // Find out middle element
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = reverse(slow);

        while (firstHalf != null && secondHalf != null) {
            ListNode temp = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = temp;

            temp = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = temp;
        }
        // Attach the last remaining node
        if (firstHalf != null) {
            firstHalf.next = null;
        }
    }

    private static ListNode reverse(ListNode slow) {
        ListNode previous = null;
        ListNode current = slow;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reOrder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}

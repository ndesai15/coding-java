package com.coding.patterns.fastslowpointers;

public class LinkedListCycleFirstNode {
    public static ListNode findCycleStart(ListNode head) {
        /*
             First check if LinkedList has a cycle or not
             if it has then get length of the cycle
         */
        int cycleLength = getCycleLength(head);
        if(cycleLength < 1) {
            return null;
        }

        /*
            After getting cycle length, create two pointers pointer1, pointer2.
            Start pointer2 at head position + length of cycle
            return the node where two pointers meet
         */
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        // move pointer2 ahead 'cycleLength' nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    private static int getCycleLength(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // It has a cycle
                return calculateCycleLength(slow);
            }
        }
        return 0;
    }

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            cycleLength++;
            current = current.next;
        } while (current != slow);
        return cycleLength;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);
    }
}

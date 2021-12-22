package com.datastructures.linkedlist.problems;

import com.coding.patterns.linkedlistInplace.ListNode;

public class LinkedListCycleLength {
    public static int getLengthOfCycle(ListNode node) {
        int length = 0;
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode temp = slow;
                length++;
                temp = temp.next;
                while (temp != slow) {
                    temp = temp.next;
                    length++;
                    return length;
                }
            }
        }
        return -1;
    }
}

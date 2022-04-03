package com.coding.patterns.linkedlists;

import com.coding.patterns.inplace.linkedlistInplace.ListNode;

/**
 * LeetCode Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class RomoveNthNodeFromEndOfList {
    public static ListNode removeNthNodeFromList(ListNode head, int n) {
        ListNode fast = head, slow = head;

        int counter = 1;
        while (counter <= n) {
            fast = fast.next;
            counter++;
        }

        if (fast == null) {
            if (head.next != null) {
                head.value = head.next.value;
                head.next = head.next.next;
            }
            else {
                head = null;
            }
            return head;
        }

        ListNode previous = null;
        while(fast != null) {
            ListNode temp = slow;
            slow = slow.next;
            fast = fast.next;
            previous = temp;
        }

        previous.next = slow.next;
        return head;
    }
}

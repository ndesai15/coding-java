package com.coding.patterns.linkedlists;

import com.coding.patterns.inplace.linkedlistInplace.ListNode;

/**
 * LeetCode Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
public class RemoveDuplicates {
    public static ListNode removeDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.value == cur.next.value) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

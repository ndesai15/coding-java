package com.coding.patterns.linkedlists;


import com.coding.patterns.inplace.linkedlistInplace.ListNode;

/**
 * LeetCode Problem: https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbersInLinkedList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.value : 0;
            int v2 = l2 != null ? l2.value : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;

            // update pointers
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return dummy.next;
    }
}

package com.coding.patterns.inplace.linkedlistInplace;

/**
 * Pattern: LinkedList InPlaceReplacement
 * LeetCode Question: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<=1) return head;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        ListNode previous = null;
        current = head;
        while (length >= k && current != null) {
            ListNode lastNodeOfFirstPart = previous;
            ListNode lastNodeOfSubList = current;
            ListNode next = null;
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            // connect with the previous part
            if(lastNodeOfFirstPart != null) {
                lastNodeOfFirstPart.next = previous;   // previous is now first node of the sublist
            }
            else {
                head = previous;
            }
            length = length - k;

            if (lastNodeOfSubList != null) {
                lastNodeOfSubList.next = current;
            }

            previous = lastNodeOfSubList;
        }
        return head;
    }
}

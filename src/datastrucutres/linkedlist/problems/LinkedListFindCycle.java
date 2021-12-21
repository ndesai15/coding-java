package datastrucutres.linkedlist.problems;

import com.coding.patterns.linkedlistInplace.ListNode;

/**
 * LeetCode problem: https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListFindCycle {
    public static boolean hasCycle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

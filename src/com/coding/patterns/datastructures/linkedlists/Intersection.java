package com.coding.patterns.datastructures.linkedlists;

import com.coding.patterns.inplace.linkedlistInplace.ListNode;

public class Intersection {
    public static ListNode findIntersect(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}

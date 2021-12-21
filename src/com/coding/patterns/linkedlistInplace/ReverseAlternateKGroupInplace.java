package com.coding.patterns.linkedlistInplace;

public class ReverseAlternateKGroupInplace {
    public static ListNode reverseAltKGroup(ListNode head, int k) {
        if(head == null || k<=1) return head;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        ListNode previous = null;
        current = head;
        while (current != null) {
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

                if (lastNodeOfSubList != null ) {
                    lastNodeOfSubList.next = current;
                }
                for (int i = 0; i < k && current != null; i++) {
                    previous = current;
                    current = current.next;
                }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = reverseAltKGroup(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

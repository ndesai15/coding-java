package com.coding.patterns.inplace.linkedlistInplace;

public class ReverseLLEvenOdd {
    public static ListNode reverseLLEvenOdd(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null){
            current = current.next;
            count++;
        }

        if (count % 2 == 0) {
            ListNode firstPart = ReverseSubList.reverseSubList(head, 1, count/2);
            ListNode secondPart = ReverseSubList.reverseSubList(head, count/2 +1, count);
            firstPart.next = secondPart;
            return firstPart;
        }
        else {
            ListNode firstPart = ReverseSubList.reverseSubList(head, 1, count/2);
            ListNode secondPart = ReverseSubList.reverseSubList(head, count/2 +2, count);
            firstPart.next = secondPart;
            return firstPart;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = reverseLLEvenOdd(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

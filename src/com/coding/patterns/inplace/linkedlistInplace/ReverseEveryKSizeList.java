package com.coding.patterns.inplace.linkedlistInplace;

public class ReverseEveryKSizeList {
    public static ListNode reverseEveryKSize(ListNode head, int k){
        if(head == null || k<=1) return head;
        ListNode previous = null, current = head;

        while (true) {
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

            // connect with the next part
            lastNodeOfSubList.next = current;
            if (current == null) {
                break;
            }
            previous = lastNodeOfSubList;
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

        ListNode result = reverseEveryKSize(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

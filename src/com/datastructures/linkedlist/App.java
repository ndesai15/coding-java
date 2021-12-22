package com.datastructures.linkedlist;

public class App {
    public static void main(String[] args) {
        Node nodeA = new Node();
        nodeA.head = 4;

        Node nodeB = new Node();
        nodeB.head = 8;

        Node nodeC = new Node();
        nodeC.head = 3;

        Node nodeD = new Node();
        nodeD.head = 5;

        nodeA.tail = nodeB;
        nodeB.tail = nodeC;
        nodeC.tail = nodeD;

        System.out.println(nodeA.tail.head);  // 8
        System.out.println(nodeA.tail == nodeB);  // true
        System.out.println(listLength(nodeA));  // 4
        System.out.println(listLength(nodeB));  // 3
        System.out.println(listLength(nodeC));  // 2

        SinglyLL mylist = new SinglyLL();
        mylist.insertFirst(4);
        mylist.insertFirst(5);
        mylist.insertFirst(6);
        mylist.insertFirst(55);
        mylist.insertFirst(99);
        mylist.insertLast(100);
        mylist.displayList();

        CircularLL circularLL = new CircularLL();
        circularLL.insertFirst(4);
        circularLL.insertFirst(5);
        circularLL.insertFirst(6);
        circularLL.insertFirst(55);
        circularLL.insertFirst(99);
        circularLL.insertLast(100);
        circularLL.displayList();

        System.out.println("Doubly LinkedList ==============");
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.inserFirst(22);
        dll.inserFirst(44);
        dll.inserFirst(66);
        dll.insertLast(11);
        dll.insertLast(33);
        dll.insertLast(55);
        dll.displayForward();
        dll.displayBackward();;
        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteKey(11);
        dll.displayForward();;
        dll.insertAfter(22, 77);
        dll.insertAfter(33, 88);
        dll.displayForward();
    }

    public static int listLength(Node aNode) {
        int length = 0;
        while (aNode != null) {
            length++;
            aNode = aNode.tail;
        }
        return length;
    }
}

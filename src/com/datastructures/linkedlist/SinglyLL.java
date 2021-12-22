package com.datastructures.linkedlist;

public class SinglyLL {
    private Node first;

    public boolean isEmpty() {
        return first == null;
    }

    // Prepend to linkedList
    public void insertFirst(int data) {
        Node newHead = new Node();
        newHead.head = data;
        newHead.tail = first;
        first = newHead;
    }

    public void insertLast(int data) {
        Node currentNode = first;
        while (currentNode.tail!= null) {
            currentNode = currentNode.tail;
        }
        Node appendNode = new Node();
        appendNode.head = data;
        currentNode.tail = appendNode;
    }

    // Delete node from beginning
    public Node deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        else if (first.tail == null) {
            first = null;
            return null;
        }
        else {
            Node holdingDeletedNode = first;
            Node temp = first.tail;
            first.tail = null;
            first = temp;
            return holdingDeletedNode;
        }
    }
    public void displayList() {
        System.out.println("List (first -> last)");
        Node currentNode = first;
        while (currentNode !=null) {
            System.out.println(currentNode.head);
            currentNode = currentNode.tail;
        }
    }

}

package datastrucutres.linkedlist;

public class CircularLL {
    private Node first;
    private Node last;

    // first and last both are null

    public boolean isEmpty() {
        return (first == null) && (last == null);
    }

    // Prepend to linkedList
    public void insertFirst(int data) {
        Node newHead = new Node();
        newHead.head = data;

        if (isEmpty()) {
            first = newHead;
            last = newHead;
        }
        else {
            newHead.tail = first;
            first = newHead;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.head = data;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        }
        else {
            last.tail = newNode; // the next value of the last node will point to the new Node
            last = newNode;  // we make the new node we created be the last one in the list
        }
    }

    public int deleteFirst() {
        int temp = first.head;
        if (isEmpty()) {
            return -1;
        }
        else if (first.tail == null){
            first = null;
            last = null;
        }
        else {
            first = first.tail;
        }
        return temp;
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

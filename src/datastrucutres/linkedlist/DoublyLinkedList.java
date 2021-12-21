package datastrucutres.linkedlist;

public class DoublyLinkedList {
    private DoublyLLNode first;
    private DoublyLLNode last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return (this.first == null) && (this.last == null);
    }

    public void inserFirst(int data) {
        DoublyLLNode node = new DoublyLLNode();
        node.data = data;
        if (this.isEmpty()) {
            first = node;
            last = node;
        }
        else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    public void insertLast(int data) {
        DoublyLLNode node = new DoublyLLNode();
        node.data = data;
        if (this.isEmpty()) {
            first = node;
            last = node;
        }
        else {
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    public DoublyLLNode deleteFirst() {
        DoublyLLNode node = first;
        if (isEmpty()) {
            return null;
        }
        else if (first.next == null){
            first = null;
            last = null;
        }
        else {
            DoublyLLNode holdingPointer = first.next;
            holdingPointer.prev = null;
            first.next = null;
            first = holdingPointer;
        }
        return node;
    }

    public DoublyLLNode deleteLast() {
        DoublyLLNode node = last;
        if (isEmpty()) {
            return null;
        }
        else if (first.next == null){
            first = null;
            last = null;
        }
        else {
            DoublyLLNode holdingPointer = last.prev;
            holdingPointer.next = null;
            last.prev = null;
            last = holdingPointer;
        }
        return node;
    }

    public boolean insertAfter(int key, int data) {
        if(this.isEmpty()) return false;
        else {
            DoublyLLNode currentNode = first;
            while (currentNode != null) {
                if (currentNode.data == key && currentNode != last) {
                    // insert here
                    DoublyLLNode newNode = new DoublyLLNode();
                    newNode.data = data;
                    DoublyLLNode currentNext = currentNode.next;
                    currentNode.next = newNode;
                    newNode.prev = currentNode;
                    newNode.next = currentNext;
                    currentNext.prev = newNode;
                    return true;
                }
                else if(currentNode.data == key) {
                    DoublyLLNode newNode = new DoublyLLNode();
                    newNode.data = data;
                    last.next = newNode;
                    last = newNode;
                    return true;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return false;
        }
    }

    public DoublyLLNode deleteKey(int key) {
        DoublyLLNode current = first;
        while (current != null) {
            if (current.data == key && current == first) {
                deleteFirst();
            }
            else if (current.data == key && current == last) {
                deleteLast();
            }
            else if(current.data == key) {
                DoublyLLNode prevNode= current.prev;
                DoublyLLNode nextNode= current.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                return current;
            }
            else {
                current = current.next;
            }
        }
        return null;
    }

    public void displayForward() {
        System.out.println("List (first--> last)");
        DoublyLLNode current = first;
        while (current != null) {
            current.displayDL();
            current = current.next;
        }
        System.out.println();
    }
    public void displayBackward() {
        System.out.println("List (last --> first)");
        DoublyLLNode current = last;
        while (current != null) {
            current.displayDL();
            current = current.prev;
        }
        System.out.println();
    }
}

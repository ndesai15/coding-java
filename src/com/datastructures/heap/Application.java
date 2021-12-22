package com.datastructures.heap;

public class Application {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(12);
        heap.insert(42);
        heap.insert(35);
        heap.insert(16);
        heap.insert(88);
        heap.insert(42);
        heap.insert(7);

        heap.displayHeap();
    }
}

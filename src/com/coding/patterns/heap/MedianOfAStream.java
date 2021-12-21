package com.coding.patterns.heap;

import java.util.PriorityQueue;

public class MedianOfAStream {
    PriorityQueue<Integer> maxHeap; // containing first half of numbers
    PriorityQueue<Integer> minHeap; // containing second half of numbers

    public MedianOfAStream() {
        // Initialize MaxHeap
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Initialize MinHeap
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        }
        else minHeap.add(num);
        // either both heaps will have same # of elements or maxHeap will have more
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        // even number of elements
        if (minHeap.size() == maxHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than min-Heap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }

}

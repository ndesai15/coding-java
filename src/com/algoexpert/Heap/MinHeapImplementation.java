package com.algoexpert.Heap;

import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
public class MinHeapImplementation {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // Time Complexity: O(N) || Space Complexity: O(1)
        public List<Integer> buildHeap(List<Integer> array) {
            int parentStart = (array.size() - 2) / 2;
            for (int parent = parentStart; parent >=0 ; parent--) {
                siftDown(parent, array.size() - 1, array);
            }
            return array;
        }

        // Time Complexity: O(logN) || Space Complexity: O(1)
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOne = 2 * currentIdx + 1;
            while (childOne <= endIdx) {
                int childTwo = 2 * currentIdx + 2 <= endIdx ? 2 * currentIdx + 2 : -1;
                int minIdx;
                if (childTwo != -1 && heap.get(childTwo) < heap.get(childOne)) {
                    minIdx = childTwo;
                }
                else {
                    minIdx = childOne;
                }
                if (heap.get(minIdx) < heap.get(currentIdx)) {
                    swap(currentIdx, minIdx, heap);
                    currentIdx = minIdx;
                    childOne = 2 * currentIdx + 1;
                }
                else {
                    return;
                }
            }
        }

        // Time Complexity: O(logN) || Space Complexity: O(1)
        public void siftUp(int currentIdx, List<Integer> heap) {
            while (true) {
                int parentIdx = (currentIdx - 1) / 2;
                if (heap.get(parentIdx) > heap.get(currentIdx)) {
                    swap(currentIdx, parentIdx, heap);
                    currentIdx = parentIdx;
                }
                else {
                    break;
                }
            }
        }

        private void swap(int idx1, int idx2, List<Integer> heap) {
            Integer temp = heap.get(idx2);
            heap.set(idx2, heap.get(idx1));
            heap.set(idx1, temp);
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }
    }
}

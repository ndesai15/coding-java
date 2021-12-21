package com.coding.patterns.kwaymerge;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int elementIndex;
    int arrayIndex;

    public Pair(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }

}

// Time Complexity O(k * logM) where M is the total sorted arrays
public class KthSmallestInMSortedArrays {
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        // Create a minHeap to perform sorted array traversal
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> lists.get(a.arrayIndex)[a.elementIndex] -
                lists.get(b.arrayIndex)[b.elementIndex]);
        // Add all the arrays first element to minHeap
        // O(K)
        for(int i = 0; i < lists.size(); i++){
            minHeap.add(new Pair(0, i));
        }
        int result = 0;
        // O(K * logM)
        // while loop will run O(K)
        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            k--;
            if (k == 0) {
                result = lists.get(pair.arrayIndex)[pair.elementIndex];
                break;
            }
            pair.elementIndex++;
            // O(log M) , where M is total number of sorted arrays
            if (lists.get(pair.arrayIndex).length > pair.elementIndex) {
                minHeap.add(pair);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}

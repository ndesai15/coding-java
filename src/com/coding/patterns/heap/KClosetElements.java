package com.coding.patterns.heap;

import java.util.*;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class KClosetElements {
    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>( new Comparator<Entry>(){
            public int compare(Entry a, Entry b){
                // if both the keys are same then compare on the bases of their values
                if((a.key - b.key) == 0)
                    return a.value - b.value;
                return a.key - b.key;
            }
        });
        for(int i: arr){
            minHeap.add(new Entry(Math.abs(i-X), i));
        }

        for(int i = 0; i < K; i++){
            Entry p = minHeap.poll();
            result.add(p.value);
        }
        Collections.sort(result);
        return result;
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        if (low > 0) {
            return low - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        //List<Integer> result = findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        //System.out.println("'K' closest numbers to 'X' are: " + result);

        //result = findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        //System.out.println("'K' closest numbers to 'X' are: " + result);

        //[0,0,1,2,3,3,4,7,7,8]
        //3
        //5
        List<Integer> result = findClosestElements(new int[] { 0,0,1,2,3,3,4,7,7,8}, 3, 5);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}

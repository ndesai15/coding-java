package com.coding.patterns.binarysearch;

public class KThLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // Time Complexity: O(N*logK), k is the number of elements at any point in time in minHeap
        // Space Complexity: O(k)
        /*PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

        for (int n: nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // output
        return minHeap.poll();*/

        // Solution # 2: Apply QuickSelect
        int position = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, position);
    }
    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int quickSelect(int[] nums, int startIdx, int endIdx, int position) {
        while(true) {
            if (startIdx > endIdx) {
                throw new RuntimeException("This is not possible!");
            }
            int pivotIdx = startIdx;
            int leftIdx = startIdx + 1;
            int rightIdx = endIdx;
            while(leftIdx <= rightIdx) {
                if (nums[leftIdx] > nums[pivotIdx] && nums[rightIdx] < nums[pivotIdx]) {
                    swap(leftIdx, rightIdx, nums);
                }
                if (nums[leftIdx] <= nums[pivotIdx]) {
                    leftIdx++;
                }
                if (nums[rightIdx] >= nums[pivotIdx]) {
                    rightIdx--;
                }
            }
            swap(rightIdx, pivotIdx, nums);
            if (rightIdx == position) return nums[rightIdx];
            if (rightIdx > position) {
                endIdx = rightIdx - 1;
            }
            else {
                startIdx = rightIdx + 1;
            }
        }
    }
}

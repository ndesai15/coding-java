package com.coding.patterns.slidingWindow;


/**
 * LeetCode Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
 * Pattern: Sliding Window + Two Pointers
 */
public class NiceSubArray {
    public static int countNiceSubArrays(int [] nums, int k) {
        int result = 0;
        int interMediate_Count=0;

        // Sliding Window
        int left=0;
        for(int right=0; right<nums.length;right++){
            if(nums[right]%2 == 1){
                k--;
                interMediate_Count = 0;
            }
            while(k == 0){
                if(nums[left++]%2==1) k++;
                interMediate_Count++;
            }
            result+= interMediate_Count;
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {2,2,2,1,2,2,1,2,2,2};
        int b[] = {1,2,2,1,2,2};
        System.out.println(countNiceSubArrays(a, 2));
        System.out.println(countNiceSubArrays(b, 2));
    }
}

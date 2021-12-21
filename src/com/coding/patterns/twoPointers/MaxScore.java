package com.coding.patterns.twoPointers;


/**
 *
 */
public class MaxScore {
    public static final int MODULO_AMT = 1000000007;
    public static int findMaxScore(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0;
        int n1 = nums1.length, n2 = nums2.length;
        long sectionSum1 = 0, sectionSum2 = 0;
        long result = 0;

        while (ptr1 < n1 && ptr2 < n2) {
            if (nums1[ptr1] < nums2[ptr2]) {
                sectionSum1 += nums1[ptr1++];
            }
            else if (nums1[ptr1] > nums2[ptr2]) {
                sectionSum2 += nums2[ptr2++];
            }
            else {
                result += Math.max(sectionSum1, sectionSum2) + nums1[ptr1];
                sectionSum1 = sectionSum2 = 0;
                ptr1++;
                ptr2++;
            }
        }
        while (ptr1 < n1) {
            sectionSum1 += nums1[ptr1++];
        }
        while (ptr2 < n2) {
            sectionSum2 += nums2[ptr2++];
        }
        return (int) ((Math.max(sectionSum1, sectionSum2) + result )% MODULO_AMT);
    }

    public static void main(String[] args) {
        int[] a = {2,4,5,8,10};
        int[] b = {4,6,8,9};
        System.out.println(findMaxScore(a, b));
    }
}

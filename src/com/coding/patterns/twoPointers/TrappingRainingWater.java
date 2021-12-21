package com.coding.patterns.twoPointers;

public class TrappingRainingWater {
    public static int calculateTrappedWater(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        left++;
        right--;
        while (left <= right) {
            if (maxLeft <= maxRight) {
                int diff = maxLeft - height[left];
                if (diff > 0) {
                    result += diff;
                }
                if (maxLeft < height[left]) {
                    maxLeft = height[left];
                }
                left++;
            }
            else {
                int diff = maxRight - height[right];
                if (diff > 0) {
                    result += diff;
                }
                if (maxRight < height[right]) {
                    maxRight = height[right];
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height1 = {4,2,0,3,2,5};
        int[] height2 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(calculateTrappedWater(height1));
        System.out.println(calculateTrappedWater(height2));
    }
}

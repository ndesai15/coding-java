package com.coding.patterns.binarysearch;

public class BoundarySearch {
    public static int findBoundary(boolean[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int boundary_index = - 1;

        while (left <= right) {
            int mid = (left + right) /  2;
            if (arr[mid]) {
                boundary_index = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return boundary_index;
    }

    public static void main(String[] args) {
        boolean[] test = {false, false, true, true, true};
        System.out.println(findBoundary(test));
        test = new boolean[]{false, false, false};
        System.out.println(findBoundary(test));
        test = new boolean[]{true, true, true};
        System.out.println(findBoundary(test));
    }
}

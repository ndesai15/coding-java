package com.coding.patterns.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement: https://algo.monster/problems/binary_search_first_element_not_smaller_than_target
 * Pattern: Binary Search
 */
public class SmallestNumber {
    public static int firstSmaller(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        int boundary_index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                boundary_index = mid;
                return boundary_index;
            }
            if (arr.get(mid) > target) {
                boundary_index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundary_index;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(8);
        list.add(10);
        System.out.println(firstSmaller(list, 2));

        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(30);
        list2.add(40);
        list2.add(50);
        System.out.println(firstSmaller(list2, 34));
    }
}

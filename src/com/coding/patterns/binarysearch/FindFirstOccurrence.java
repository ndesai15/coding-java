package com.coding.patterns.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindFirstOccurrence {
    public static int findFirstOccurrence(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int first_occurrence = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == target) {
                first_occurrence = mid;
                right = mid - 1;
            }
            else if (list.get(mid) < target) {
                left = mid + 1;
            }
            else {
                // > value
                right = mid - 1;
            }
        }

        return first_occurrence;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(6);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(100);
        System.out.println(findFirstOccurrence(list, 3));
    }
}

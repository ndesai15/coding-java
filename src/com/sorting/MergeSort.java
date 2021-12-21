package com.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<Integer> sort(List<Integer> arr) {
        return sort(arr, 0, arr.size());
    }
    private static List<Integer> sort(List<Integer> list, int start, int end) {
        if (end - start <= 1) {
            return list.subList(start, end);
        }
        int mid = (start + end) / 2;
        List<Integer> leftList = sort(list, start, mid);
        List<Integer> rightList = sort(list, mid, end);

        int leftPointer = 0, rightPointer = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (leftPointer < leftList.size() || rightPointer < rightList.size()) {
            if (leftPointer == leftList.size()) {
                result.add(rightList.get(rightPointer++));
            }
            else if (rightPointer == rightList.size()) {
                result.add(leftList.get(leftPointer++));
            }
            else if (leftList.get(leftPointer) <= rightList.get(rightPointer)) {
                result.add(leftList.get(leftPointer++));
            }
            else {
                result.add(rightList.get(rightPointer++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(10);
        list.add(20);
        list.add(40);
        list.add(35);
        System.out.println(sort(list));
    }

}

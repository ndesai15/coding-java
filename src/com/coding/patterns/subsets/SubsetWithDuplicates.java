package com.coding.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();

        // Add an empty arraylist to subsets to start with
        subsets.add(new ArrayList<Integer>());
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            // if the current and previous elements are same, create new subsets only from the
            // previously created subsets
            if (i > 0 && nums[i] == nums[i-1]) {
                start = end + 1;
            }
            end = subsets.size() - 1;
            for (int j = start; j <= end; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<Integer>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        //List<List<Integer>> result = findSubsets(new int[] { 1, 3, 3 });
        //System.out.println("Here is the list of subsets: " + result);

        List<List<Integer>> result = findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

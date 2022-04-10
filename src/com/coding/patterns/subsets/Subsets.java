package com.coding.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private static void dfs(List<List<Integer>> result, List<Integer> current, int i, int[] nums) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // decision to include nums[i]
        current.add(nums[i]);
        dfs(result, current, i + 1, nums);

        // decision to NOT TO include nums[i]
        current.remove(current.size() - 1);
        dfs(result, current, i + 1, nums);
    }
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(result, current, 0, nums);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

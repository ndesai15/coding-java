package com.coding.patterns.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode problem: https://leetcode.com/problems/permutations-ii/
 * Pattern: BackTracking
 */
public class PermutationForDuplicates {
    public static List<List<Integer>> findPermutation(int[] nums) {
        // [1, 1,2] => [1,1,2], [1,2,1], [2,1,1]
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0 || nums == null) {
            return result;
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int n: nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        dfs(result, new ArrayList<Integer>(), countMap, nums);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> path, HashMap<Integer, Integer>
                            counterMap, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int key: counterMap.keySet()) {
            if (counterMap.get(key) > 0) {
                path.add(key);
                counterMap.put(key, counterMap.get(key) - 1);
                dfs(result, path, counterMap, nums);

                // backtrack
                path.remove(path.size() - 1);
                counterMap.put(key, counterMap.get(key) + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findPermutation(new int[]{1,1,2}));
    }
}

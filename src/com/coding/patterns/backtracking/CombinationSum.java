package com.coding.patterns.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    private static void backTrack(int[] candidates, int target, int total, int i, List<Integer> current,
                                  List<List<Integer>> result) {
        if (target == total) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (total > target || i >= candidates.length) {
            return;
        }

        // Include i
        current.add(0, candidates[i]);
        backTrack(candidates, target, total + candidates[i], i, current, result);

        // Not include i
        current.remove(0);
        backTrack(candidates, target, total, i + 1, current, result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new LinkedList<>();

        backTrack(candidates, target, 0, 0, current, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

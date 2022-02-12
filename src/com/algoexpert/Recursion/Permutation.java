package com.algoexpert.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * AlgoExpert Problem:https://www.algoexpert.io/questions/Permutations
 *
 */

// Time Complexity: O(N! *N)
// Space Complexity: O(N! * N)
public class Permutation {
    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
    private static void dfs(int i, List<Integer> array, List<List<Integer>> result) {
        if (i == array.size() - 1) {
            result.add(new ArrayList<>(array));
        }
        for (int j = i; j < array.size(); j++) {
            swap(array, i, j);
            dfs(i + 1,  array, result);
            swap(array, i, j);
        }
    }
    public static List<List<Integer>> allPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, array, result);
        return result;
    }
}

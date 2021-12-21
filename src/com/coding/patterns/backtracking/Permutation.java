package com.coding.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Character>> permutate(char[] letters) {
        List<List<Character>> result = new ArrayList<>();
        if (letters.length == 0 || letters == null) {
            return result;
        }
        dfs(new ArrayList<Character>(), result, letters, new boolean[letters.length]);
        return result;
    }

    private static void dfs(ArrayList<Character> path, List<List<Character>> result,
                            char[] letters, boolean[] visited) {
        if (path.size() == letters.length) {
            // we constructed path
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < letters.length; i++) {
            if (visited[i]) continue;
            path.add(letters[i]);
            visited[i] = true;
            dfs(path, result, letters, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permutate(new char[] {'a', 'b', 'c'}));
    }
}

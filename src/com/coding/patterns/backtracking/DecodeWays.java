package com.coding.patterns.backtracking;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecodeWays {
    private static final List<String> LETTERS =
            IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());

    public static int countDecodeWays(String digits) {
        if (digits.isEmpty() || digits == null) return 0;
        return dfs(0, new int[digits.length()], digits);
    }

    private static int dfs(int i, int[] memo, String digits) {
        if (i == digits.length()) return 1;
        if (memo[i] != 0) return memo[i];

        int ways = 0;
        for (String prefix: LETTERS) {
            if (digits.substring(i).startsWith(prefix)) {
                ways += dfs(i + prefix.length(), memo, digits);
            }
        }
        memo[i] = ways;
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(countDecodeWays("123"));
    }
}

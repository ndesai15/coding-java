package com.coding.patterns.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // Create a cache
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordDictSet = new HashSet<>(wordDict);

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    private static boolean dfs(int i, Boolean[] memo, String s, List<String> wordDict) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];

        boolean result = false;
        for (String word: wordDict) {
            if (s.substring(i).startsWith(word))  {
                result = dfs(i + word.length(), memo, s, wordDict);
            }
        }
        memo[i] = result;
        return result;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        return dfs(0, new Boolean[s.length()],s, wordDict);
    }

    public static void main(String[] args) {
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        System.out.println(wordBreak("leetcode",wordDict1));
    }
}

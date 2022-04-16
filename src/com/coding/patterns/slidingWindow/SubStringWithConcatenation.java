package com.coding.patterns.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * LeetCode Problem: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

// Time Complexity: O(N * M * Len), N is the number of characters in String s, M is the total # of words, Len is length of word
public class SubStringWithConcatenation {
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word: words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int windowStart = 0; windowStart <= s.length() - wordsCount * wordLength; windowStart++) {
            Map<String, Integer> wordsSeen = new HashMap<String, Integer>();

            for (int windowEnd = 0; windowEnd < wordsCount; windowEnd++) {
                int nextWordIndex = windowStart + windowEnd * wordLength;

                // get the next word from the string
                String word = s.substring(nextWordIndex, nextWordIndex + wordLength);

                if (!wordFrequencyMap.containsKey(word)) { // break if we don't need this word
                    break;
                }

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                // no need to process further if the word has higherfrequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.get(word)){
                    break;
                }

                if (windowEnd + 1 == wordsCount) { // store index if we have found all the words
                    resultIndices.add(windowStart);
                }
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}

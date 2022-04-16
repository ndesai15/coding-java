package com.coding.patterns.bfs;

import javax.management.MBeanRegistrationException;
import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> neighbors = new HashMap<>();
        wordList.add(beginWord);

        // since all words have same length
        int L = beginWord.length();

        wordList.forEach(
                word -> {
                        for (int i = 0; i < L; i++) {
                            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                            List<String> existingTransformedWords = neighbors.computeIfAbsent(newWord, k -> new ArrayList<String>());
                            existingTransformedWords.add(word);
                        }
            }
        );

        // BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int bfsCount = 1;
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String word = queue.remove();
                if (word.equals(endWord)) {
                    return bfsCount;
                }
                for (int j = 0; j < word.length(); j++) {
                    String newWord = word.substring(0, j) + '*' + word.substring(j + 1, L);
                    for (String adjWord: neighbors.getOrDefault(newWord, new ArrayList<>())) {
                        if (!visited.contains(adjWord)) {
                            visited.add(adjWord);
                            queue.add(adjWord);
                        }
                    }
                }
            }
            bfsCount += 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        System.out.println(ladderLength("hit","cog", words));
    }
}

package com.coding.patterns.trie;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        // Create a root node of TrieNode data structure
        TrieNode root = new TrieNode();

        // Add word to TrieNode datastructure
        for(String w: words) {
            root.addWord(w);
        }

        int rows = board.length, cols = board[0].length;
        Set<String> result = new HashSet<>();
        String word = "";
        Set<Pair> visited = new HashSet<Pair>();
        for (int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                dfs(rows, cols, r, c, root, result, visited, word, board);
            }
        }

        return new ArrayList<String>(result);
    }

    private static void dfs(int rows, int cols, int r, int c, TrieNode current, Set<String> result, Set<Pair> visited,
                     String word, char[][] board) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited.contains(new Pair(r, c)) ||
                !current.children.containsKey(board[r][c])) {
            return;
        }
        visited.add(new Pair(r,c));
        word = word + board[r][c];
        current = current.children.get(board[r][c]);
        // Add to result if current word is endOf word
        if (current.endOfWord) {
            result.add(word);
        }
        dfs(rows, cols, r, c + 1, current, result, visited, word, board);
        dfs(rows, cols, r, c - 1, current, result, visited, word, board);
        dfs(rows, cols, r + 1, c, current, result, visited, word, board);
        dfs(rows, cols, r - 1, c, current, result, visited, word, board);
        // backtracking
        visited.remove(new Pair(r, c));
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

package com.coding.patterns.basicprogramming;

import java.util.*;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isEndOfWord = false;

    public TrieNode() {}

    public void addWord(String word) {
        TrieNode current = this;

        for (char ch: word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode());
            }
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }
}
public class JayBahuchar {
    private static void dfs(int r, int c, int rows, int cols, String word, TrieNode node,
                            Set<String> visited, Set<String> result, char[][] board) {
        if (r < 0 || r >= rows || c >= cols || c < 0 || visited.contains(r + "," + c) || !node.children.containsKey(board[r][c])) {
            return;
        }
        word += board[r][c];
        visited.add(r + "," + c);
        node = node.children.get(board[r][c]);
        if (node.isEndOfWord) {
            result.add(word);
        }
        dfs(r, c + 1, rows, cols, word, node, visited, result, board);
        dfs(r - 1, c + 1, rows, cols, word, node, visited, result, board);
        dfs(r - 1, c, rows, cols, word, node, visited, result, board);
        dfs(r + 1, c + 1, rows, cols, word, node, visited, result, board);
        dfs(r + 1, c, rows, cols, word, node, visited, result, board);
        dfs(r + 1, c - 1, rows, cols, word, node, visited, result, board);
        dfs(r , c - 1, rows, cols, word, node, visited, result, board);
        dfs(r - 1, c - 1, rows, cols, word, node, visited, result, board);

        visited.remove(r + "," + c);
    }
    public static List<String> boggleBoard(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            root.addWord(word);
        }
        int rows = board.length, cols = board[0].length;
        String word = "";
        Set<String> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(r, c, rows, cols, word, root, visited, result, board);
            }
        }
        return new ArrayList<String>(result);
    }
}

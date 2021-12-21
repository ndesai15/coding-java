package com.coding.patterns.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // Children of a node(root)
    Map<Character, TrieNode> children = new HashMap<>();

    // Is it end of word?
    boolean endOfWord = false;

    public TrieNode() {}

    // Add a word to Trie
    public void addWord(String word) {
        TrieNode current = this;

        for(char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        // Set end of word
        current.endOfWord = true;
    }

}

package com.coding.patterns.trie;

/**
 * Pattern: Use of Trie Data structure
 * Leetcode problem: https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class WordDictionary {

    // Initialize Trie Data structure
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word to Trie
    public void addWord(String word) {
        TrieNode current = root;

        for(char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        // Set end of word
        current.endOfWord = true;
    }

    private boolean searchInRoot(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // character might be .
                if (ch == '.') {
                    for(char c: node.children.keySet()) {
                        TrieNode child = node.children.get(c);
                        if (searchInRoot(word.substring(i+1), child)) {
                            return true;
                        }
                    }
                }
                // if character doesn't exist
                return false;
            }
            else {
                node = node.children.get(ch);
            }
        }
        return node.endOfWord;
    }

    // Search word in Trie data structure
    public boolean search(String word) {
        return searchInRoot(word,root);
    }
}

class Application {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));  // false
        System.out.println(wd.search("bad"));  // true
        System.out.println(wd.search(".ad"));  // true
        System.out.println(wd.search("b.."));  // true
    }
}

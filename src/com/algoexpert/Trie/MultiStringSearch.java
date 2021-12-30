package com.algoexpert.Trie;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
}

class ModifiedSuffixTrie {
    TrieNode root = new TrieNode();

    public ModifiedSuffixTrie(String str) {
        populateModifiedSuffixTrieFrom(str);
    }

    private void populateModifiedSuffixTrieFrom(String str) {
        for (int i = 0; i < str.length(); i++) {
            TrieNode node = root;
            for (int j = i; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
        }
    }

    public boolean contains(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return true;
    }
}

public class MultiStringSearch {
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        ModifiedSuffixTrie modifiedSuffixTrie = new ModifiedSuffixTrie(bigString);
        List<Boolean> solution = new ArrayList<Boolean>();
        for (String smallString: smallStrings) {
            solution.add(modifiedSuffixTrie.contains(smallString));
        }
        return solution;
    }
}


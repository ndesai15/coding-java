package com.algoexpert.Trie;
import java.util.*;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Suffix%20Trie%20Construction
 */
public class SuffixTrieConstruction {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        /*
          Time Complexity: O(N^2) -> N is a length of searching tree
          Space Complexity: O(N^2) -> In worst case all characters are different
        */
        public void populateSuffixTrieFrom(String str) {
            TrieNode current = root;
            int n = str.length();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (!current.children.containsKey(str.charAt(j))) {
                        current.children.put(str.charAt(j), new TrieNode());
                    }
                    current = current.children.get(str.charAt(j));
                }
                current.children.put(endSymbol, null);
                current = root;
            }
        }

        /*
          Time Complexity: O(M) -> M is a length of searching tree
          Space Complexity: O(1)
        */
        public boolean contains(String str) {
            TrieNode current = root;
            int n = str.length();
            for (int i = 0; i < n; i++) {
                if (!current.children.containsKey(str.charAt(i))) {
                    return false;
                }
                current = current.children.get(str.charAt(i));
            }
            return current.children.containsKey(endSymbol);
        }
    }
}

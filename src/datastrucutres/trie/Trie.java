package datastrucutres.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Iterative approach of inserting into a tree
     */
    public void insert(String word) {
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            if(!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode());
            }
            current = current.children.get(ch);
        }
        current.endOfWord = true;
    }

    /**
     * Iterative approach of searching in a tree
     */
    public boolean search(String word) {
        TrieNode current = root;
        for(char ch: word.toCharArray()) {
            if(!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        // return if word ends or not.
        return current.endOfWord;
    }

    /**
     * Delete a word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode root, String word, int index) {
        if (index == word.length()) {
            // check if end of word is reached only delete if current.endOfWord is true
            if (!root.endOfWord) {
                return false;
            }
            root.endOfWord = false;
            // if root has no other mapping then return true
            return root.children.size() == 0;
        }
        char ch = word.charAt(index);
        if(!root.children.containsKey(ch)) {
            return false;
        }
        boolean shouldDeleteNode = delete(root.children.get(ch), word, index+ 1);

        // if true then delete the mapping of character & triNode reference from map.
        if (shouldDeleteNode) {
            root.children.remove(ch);
            // return true if no mappings are left in the map.
            return root.children.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
        System.out.println(trie.search("abc"));  // true
        System.out.println(trie.search("abcd")); // true
        System.out.println(trie.search("lmo")); // false
        trie.insert("lmo");
        System.out.println(trie.search("lmo")); // true
        trie.delete("abc");
        System.out.println(trie.search("abc"));  // false
        System.out.println(trie.search("abcd")); // true
    }
}



package com.algoexpert.Strings;

public class CeaserCipher {
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static String solution1(String str, int key) {
        return caesarCypherEncryptor1(str, key);
    }
    private static char getNewLetter1(int key, char current) {
        int newLetterCode = current + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }
    private static String caesarCypherEncryptor1(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;

        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter1(newKey, str.charAt(i));
        }
        return new String(newLetters);
    }

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static String solution2(String str, int key) {
        return caesarCypherEncryptor2(str, key);
    }

    private static char getNewLetter2(int key, char current, String alphabet) {
        int currentIdx = alphabet.indexOf(current);
        int newLetterIdx = currentIdx + key;
        return newLetterIdx <= 25 ? alphabet.charAt(newLetterIdx) : alphabet.charAt(newLetterIdx % 26);
    }

    public static String caesarCypherEncryptor2(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter2(newKey, str.charAt(i), alphabet);
        }
        return new String(newLetters);
    }
}

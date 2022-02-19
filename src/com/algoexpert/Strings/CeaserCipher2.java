package com.algoexpert.Strings;


// Facebook Recruitment Problems
// Time Complexity: O(N)
// Space Complexity: O(N)
public class CeaserCipher2 {
    // Add any helper functions you may need here
    private char getNewCharacter(int newKey, char current, String alphaBet, boolean isDigit) {
        int currentIdx = alphaBet.indexOf(current);
        int newLetterIdx = currentIdx + newKey;
        if (!isDigit) {
            return newLetterIdx <= 25 ? alphaBet.charAt(newLetterIdx) : alphaBet.charAt(newLetterIdx % 26);
        }
        else {
            return newLetterIdx <= 9 ? alphaBet.charAt(newLetterIdx) : alphaBet.charAt(newLetterIdx % 10);
        }
    }

    public String rotationalCipher(String input, int rotationFactor) {
        int newKeyForLetter = rotationFactor % 26;
        int newKeyForDigit = rotationFactor % 10;
        char[] result = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                result[i] = ch;
            }
            else if (Character.isDigit(ch)) {
                result[i] = getNewCharacter(newKeyForDigit, ch, "0123456789", true);
            }
            else if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    result[i] = getNewCharacter(newKeyForLetter, ch, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", false);
                }
                else {
                    result[i] = getNewCharacter(newKeyForLetter, ch, "abcdefghijklmnopqrstuvwxyz", false);
                }
            }
        }
        return new String(result);
    }
}

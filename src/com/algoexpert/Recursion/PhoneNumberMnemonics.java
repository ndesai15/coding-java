package com.algoexpert.Recursion;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LeetCode Problem: https://www.algoexpert.io/questions/Phone%20Number%20Mnemonics
 */

// Time Complexity: O(4^N * N)
// Space Complexity: O(4^N * N)
public class PhoneNumberMnemonics {
    private static void dfs(int i, String str, ArrayList<String> result, HashMap<Integer, String> map, String temp) {
        if (i == str.length()) {
            result.add(new String(temp));
            return;
        }
        else {
            char current = str.charAt(i);
            String phoneStr = map.get(Integer.parseInt(String.valueOf(current)));
            for (char ch: phoneStr.toCharArray()) {
                String placeHolder = temp;
                dfs(i + 1, str, result, map, temp + ch);
                temp = placeHolder;
            }
        }
    }
    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        ArrayList<String> result = new ArrayList<>();
        dfs(0, phoneNumber, result, map, "");
        return result;
    }

    public static void main(String[] args) {
        System.out.println(phoneNumberMnemonics("1905"));
    }
}

package com.coding.patterns.backtracking;

import java.util.ArrayList;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Valid%20IP%20Addresses
 */
// Time Complexity: O(1), because length of input string is fix
// Space Complexity :O(1), because length of input string is fix
public class ValidIpAddresses {
    private boolean isValidPart(String string) {
        int stringAsInt = Integer.parseInt(string);
        if (stringAsInt > 255) {
            return false;
        }
        return string.length() == Integer.toString(stringAsInt).length();
    }
    private String join (String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < strings.length; l++) {
            sb.append(strings[l]);
            if (l < strings.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
    public ArrayList<String> validIPAddresses(String str) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i < Math.min(str.length(), 4); i++) {
            String[] currentIPAddressParts = new String[]{"", "", "", ""};

            currentIPAddressParts[0] = str.substring(0, i);
            if (!isValidPart(currentIPAddressParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min((int)str.length() - i, 4); j++) {
                currentIPAddressParts[1] = str.substring(i, j);
                if (!isValidPart(currentIPAddressParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min((int) str.length() - j, 4); k++) {
                    currentIPAddressParts[2] = str.substring(j, k);
                    currentIPAddressParts[3] = str.substring(k);
                    if (isValidPart(currentIPAddressParts[2]) && isValidPart(currentIPAddressParts[3])) {
                        result.add(join(currentIPAddressParts));
                    }
                }
            }
        }
        return result;
    }
}

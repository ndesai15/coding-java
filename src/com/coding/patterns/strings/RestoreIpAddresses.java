package com.coding.patterns.strings;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem: https://leetcode.com/problems/restore-ip-addresses/
 */
// Time Complexity: O(1)
// Space Complexity: O(1)
public class RestoreIpAddresses {
    private boolean isValidIp(String str) {
        long stringAsInt = Long.parseLong(str);
        if (stringAsInt > 255) {
            return false;
        }
        return str.length() == Long.toString(stringAsInt).length();
    }

    private String join(String[] strs) {
        StringBuilder sb = new StringBuilder();

        for (int l = 0; l < strs.length; l++) {
            sb.append(strs[l]);
            if (l < strs.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();

        String[] currentIp = new String[]{"", "", "", ""};
        int n = s.length();
        for (int i = 1; i < Math.min(n, 4); i++) {
            currentIp[0] = s.substring(0, i);

            if (!isValidIp(currentIp[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min(n - i, 4); j++) {
                currentIp[1] = s.substring(i, j);

                if (!isValidIp(currentIp[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min(n - j, 4); k++) {
                    currentIp[2] = s.substring(j, k);
                    currentIp[3] = s.substring(k, n);

                    if (isValidIp(currentIp[2]) && isValidIp(currentIp[3])) {
                        result.add(join(currentIp));
                    }
                }
            }
        }
        return result;
    }
}

package com.algobot76.lintcode._1639;

import java.util.HashSet;
import java.util.Set;

/**
 * Two Pointers
 */
public class Solution1 {
    /**
     * @param stringIn: The original string.
     * @param K:        The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        if (stringIn == null || stringIn.length() == 0 || stringIn.length() < K) {
            return 0;
        }

        Set<Character> charSet = new HashSet<>();
        Set<String> resSet = new HashSet<>();
        for (int i = 0, j = 0; i < stringIn.length(); i++) {
            while (j < stringIn.length() && charSet.size() < K) {
                char ch = stringIn.charAt(j);
                if (charSet.contains(ch)) {
                    break;
                }
                charSet.add(ch);
                if (charSet.size() == K) {
                    resSet.add(stringIn.substring(i, j + 1));
                }
                j++;
            }
            charSet.remove(stringIn.charAt(i));
        }

        return resSet.size();
    }
}

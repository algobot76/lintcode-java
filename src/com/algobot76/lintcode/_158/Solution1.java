package com.algobot76.lintcode._158;

import java.util.Arrays;

public class Solution1 {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int[] sCount = new int[256];
        int[] tCount = new int[256];
        for (char c : s.toCharArray()) {
            sCount[c]++;
        }
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        return Arrays.equals(sCount, tCount);
    }
}

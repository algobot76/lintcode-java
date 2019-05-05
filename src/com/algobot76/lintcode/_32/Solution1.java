package com.algobot76.lintcode._32;

import java.util.Arrays;

/**
 * Two Pointers
 */
public class Solution1 {
    /**
     * @param source  : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (target.length() == 0) {
            return "";
        }

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int[] sCount = new int[256];
        int[] tCount = new int[256];
        Arrays.fill(sCount, 0);
        Arrays.fill(tCount, 0);
        int uniqueChars = 0;
        for (char ch : t) {
            tCount[ch]++;
            if (tCount[ch] == 1) {
                uniqueChars++;
            }
        }
        int currChars = 0;
        int ansL = -1;
        int ansR = -1;

        for (int l = 0, r = 0; l < s.length; l++) {
            while (r < s.length && currChars < uniqueChars) {
                sCount[s[r]]++;
                if (sCount[s[r]] == tCount[s[r]]) {
                    currChars++;
                }
                r++;
            }
            if (currChars == uniqueChars) {
                if (ansL == -1 || r - l < ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }
            }
            sCount[s[l]]--;
            if (sCount[s[l]] == tCount[s[l]] - 1) {
                currChars--;
            }
        }

        if (ansL == -1) {
            return "";
        }
        return source.substring(ansL, ansR);
    }
}

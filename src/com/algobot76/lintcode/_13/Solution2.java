package com.algobot76.lintcode._13;

/**
 * KMP
 */
public class Solution2 {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (target.length() == 0) {
            return 0;
        }

        int[] next = getNext(target);
        int i = 0;
        int j = 0;
        int sLen = source.length();
        int tLen = target.length();
        while (i < sLen && j < tLen) {
            if (j == -1 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == tLen ? i - j : -1;
    }

    private int[] getNext(String target) {
        int len = target.length();
        int[] next = new int[len];

        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || target.charAt(i) == target.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}

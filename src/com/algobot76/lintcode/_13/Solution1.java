package com.algobot76.lintcode._13;

/**
 * Two Pointers
 */
public class Solution1 {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        String curr;
        int ans = -1;

        for (int l = 0, r = 0; r <= source.length(); r++) {
            curr = source.substring(l, r);
            if (curr.equals(target)) {
                ans = l;
                break;
            } else if (curr.length() == target.length()) {
                l++;
            }
        }

        return ans;
    }
}

package com.algobot76.lintcode._386;

/**
 * Two Pointers
 */
public class Solution1 {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int[] count = new int[256];
        char[] sc = s.toCharArray();
        int len = 0;
        int ans = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            count[sc[r]]++;
            if (count[sc[r]] == 1) {
                len++;
            }
            while (len > k) {
                count[sc[l]]--;
                if (count[sc[l]] == 0) {
                    len--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
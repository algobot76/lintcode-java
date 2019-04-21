package com.algobot76.lintcode._384;

/**
 * Two Pointers
 */
public class Solution1 {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int[] count = new int[256];
        char[] input = s.toCharArray();
        int ans = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            count[input[r]]++;
            while (count[input[r]] > 1) {
                count[input[l]]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}

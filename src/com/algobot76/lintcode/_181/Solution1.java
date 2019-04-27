package com.algobot76.lintcode._181;

/**
 * XOR
 */
public class Solution1 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        // write your code here
        int count = 0;

        for (int c = a ^ b; c != 0; c = c >>> 1) {
            count += c & 1;
        }

        return count;
    }
}

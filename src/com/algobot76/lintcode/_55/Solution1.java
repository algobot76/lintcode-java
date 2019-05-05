package com.algobot76.lintcode._55;

public class Solution1 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        int[] aCount = new int[26];
        int[] bCount = new int[26];

        for (char ch : A.toCharArray()) {
            aCount[ch - 'A']++;
        }
        for (char ch : B.toCharArray()) {
            bCount[ch - 'A']++;
        }

        for (int i = 0; i < B.length(); i++) {
            if (bCount[i] > aCount[i]) {
                return false;
            }
        }
        return true;
    }
}

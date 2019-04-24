package com.algobot76.lintcode._189;

public class Solution1 {
    /**
     * @param A: An array of integers
     * @return: An integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        int len = A.length;
        for (int i = 0; i < len; i++) {
            A[i]--;
        }
        for (int i = 0; i < len; i++) {
            while (A[i] != i && A[i] >= 0 && A[i] < len && A[i] != A[A[i]]) {
                int temp = A[i];
                A[i] = A[A[i]];
                A[temp] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (A[i] != i) {
                return i + 1;
            }
        }

        return len + 1;
    }
}

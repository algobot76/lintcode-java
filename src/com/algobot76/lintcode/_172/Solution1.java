package com.algobot76.lintcode._172;

public class Solution1 {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            if (A[l] == elem) {
                A[l] = A[r];
                r--;
            } else {
                l++;
            }
        }

        return r + 1;
    }
}

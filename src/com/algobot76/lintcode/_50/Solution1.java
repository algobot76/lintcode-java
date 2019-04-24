package com.algobot76.lintcode._50;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        List<Long> ans = new ArrayList<>(nums.size());

        long temp = 1;
        for (int i = 0; i < len; i++) {
            ans.add(temp);
            temp *= nums.get(i);
        }
        temp = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans.set(i, ans.get(i) * temp);
            temp *= nums.get(i);
        }

        return ans;
    }
}

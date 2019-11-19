package com.algobot76.lintcode._533;

import java.util.Arrays;

public class Solution1 {
    /**
     * @param nums:   an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        int diff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else {
                left++;
            }
            diff = Math.min(diff, Math.abs(sum - target));
        }

        return diff;

    }
}

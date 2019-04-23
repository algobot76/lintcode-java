package com.algobot76.lintcode._100;

/**
 * Two Pointers
 */
public class Solution1 {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];
            }
        }

        return size + 1;
    }
}

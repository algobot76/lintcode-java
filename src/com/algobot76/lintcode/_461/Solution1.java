package com.algobot76.lintcode._461;

/**
 * Quick Select
 */
public class Solution1 {
    /**
     * @param k:    An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }
        int left = start;
        int right = end;
        int pivot = arr[(start + end) / 2];
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        if (right >= k && start <= right) {
            return quickSelect(arr, start, right, k);
        } else if (left <= k && left <= end) {
            return quickSelect(arr, left, end, k);
        } else {
            return arr[k];
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

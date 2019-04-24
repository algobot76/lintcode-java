package com.algobot76.lintcode._56;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash Table
 */
public class Solution1 {
    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int[] ans = {map.get(numbers[i]), i};
                return ans;
            }
            map.put(target - numbers[i], i);
        }

        int[] ans = new int[2];
        return ans;
    }
}

package com.algobot76.lintcode._171;

import java.util.*;

public class Solution1 {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            if (str.isEmpty()) {
                String key = "#";
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>(Arrays.asList("")));
                } else {
                    map.get(key).add("");
                }
            } else {
                int[] count = new int[26];
                for (char ch : str.toCharArray()) {
                    count[ch - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int c : count) {
                    sb.append("#");
                    sb.append(c);
                }
                String key = sb.toString();
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>(Arrays.asList(str)));
                } else {
                    map.get(key).add(str);
                }
            }
        }

        for (List<String> list : map.values()) {
            if (list.size() >= 2) {
                ans.addAll(list);
            }
        }

        return ans;
    }
}

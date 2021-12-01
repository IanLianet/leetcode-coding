package org.ianlai.leetcodejava.official.range100;

import java.util.HashMap;
import java.util.HashSet;

public class LC_official_0003_longest_substring_without_repeating_characters {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLength = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            if(hashMap.containsKey(s.charAt(right))){
                left = Math.max(left,hashMap.get(s.charAt(right))+1);
                hashMap.remove(s.charAt(right));
            }
            hashMap.put(s.charAt(right),right);
            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength;
    }
}


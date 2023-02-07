package org.ianlai.leetcodejava.official.range100;

public class LC_official_0005_longestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(longestPalindrome(s));
    }

    /*
    给你一个字符串 s，找到 s 中最长的回文子串。

    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。

    示例 2：
    输入：s = "cbbd"
    输出："bb"

    提示：
    1 <= s.length <= 1000
    s 仅由数字和英文字母组成
     */
    public static String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }
        int i, finalI = 0;
        int maxLength = 1;
        for (i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                finalI = i - (maxLength - 1) / 2;
            }
        }

        return s.substring(finalI, finalI + maxLength);
    }

    private static int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}


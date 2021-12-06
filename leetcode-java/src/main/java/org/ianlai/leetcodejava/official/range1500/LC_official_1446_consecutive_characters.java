package org.ianlai.leetcodejava.official.range1500;

public class LC_official_1446_consecutive_characters {
    public static void main(String[] args) {

    }

    /*
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了74.67%的用户
     */
    public static int maxPower(String s) {
        int substringLength = 1;
        int maxLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                maxLength = Math.max(maxLength, substringLength);
                substringLength = 1;
            } else
                substringLength++;
        }
        maxLength = Math.max(maxLength, substringLength);
        return maxLength;
    }
}


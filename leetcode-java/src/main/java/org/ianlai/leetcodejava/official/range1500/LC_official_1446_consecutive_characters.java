package org.ianlai.leetcodejava.official.range1500;

public class LC_official_1446_consecutive_characters {
    public static void main(String[] args) {

    }

    /*
     * 上届爆了估计，所以答案不对，寄了
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


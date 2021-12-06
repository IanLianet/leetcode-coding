package org.ianlai.leetcodejava.official.range1900;

public class LC_official_1816_truncate_sentence {
    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;
        System.out.println(truncateSentence2(s,k));
    }

    /*
     * 执行用时：1 ms, 在所有 Java 提交中击败了65.28%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了55.26%的用户
     */
    public static String truncateSentence(String s, int k) {
        String[] array = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < k; i++) {
            stringBuffer.append(array[i]).append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }


    /*
     * 执行用时：1 ms, 在所有 Java 提交中击败了65.28%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了95.11%的用户
     */
    public static String truncateSentence2(String s, int k) {

        int count = 0;
        int i;
        for (i = 0; i <= s.length(); i++) {
            if (i == s.length()|| s.charAt(i) == ' ') {
                count++;
            }
            if (count == k)
                break;
        }
        return s.substring(0, i);
    }
}


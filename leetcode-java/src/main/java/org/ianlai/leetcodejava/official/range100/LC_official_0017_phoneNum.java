package org.ianlai.leetcodejava.official.range100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LC_official_0017_phoneNum {
    public static void main(String[] args) {
        String s = "";
        System.out.println(letterCombinations(s));
    }

    /*
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


     */
    private static List<String> defaultList = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pgrs", "tuv", "wxyz"));
    private static char[] digitChars;


    public static List<String> letterCombinations(String digits) {
        List<String> ansList = new ArrayList<>();
        digitChars = digits.toCharArray();
        int length = digitChars.length;
        StringBuilder stringBuilder = new StringBuilder();
        loop(ansList, 0, length, stringBuilder);
        stringBuilder.delete(0, length);
        return ansList;
    }

    public static void loop(List<String> ansList, int i, int length, StringBuilder sb) {
        if (i == length) {
            if (length != 0) {
                ansList.add(sb.toString());
            }

        } else {
            String s = defaultList.get(digitChars[i] - '0' - 2);
            for (char c : s.toCharArray()) {
                sb.append(c);
                loop(ansList, i + 1, length, sb);
                sb.deleteCharAt(i);
            }
        }
    }

}


package org.ianlai.leetcodejava.official.range100;

import static org.ianlai.leetcodejava.official.range100.LC_official_0005_longestPalindromicSubstring.longestPalindrome;

public class LC_official_0011 {
    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(longestPalindrome(s));
    }

    /*
    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量

     */
    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int temp = 0;
        int heightLeft, heightRight;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            temp = Math.min(height[i], height[j]) * (j - i);
            if (temp > maxArea) {
                maxArea = temp;
            }
            if (height[i] < height[j]) {
                heightLeft = height[i];
                while (i < j && heightLeft >= height[i]) {
                    i++;
                }
            } else {
                heightRight = height[j];
                while (i < j && heightRight >= height[j]) {
                    j--;
                }
            }
        }
        return maxArea;
    }

}


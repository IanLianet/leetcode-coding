package org.ianlai.leetcodejava.official.range100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class LC_official_0015_threeSum {
    public static void main(String[] args) {
        String s = "ccc";
        System.out.println();
    }

    /*
    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。


     */



    public List<List<Integer>> threeSum(int[] nums) {

        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        int currentTarget, currentNum;
        int i, j;
        List<List<Integer>> ans = new ArrayList<>();
        i = 0;
        while (i < sortedNums.length - 2) {
            currentTarget = sortedNums[i];
            HashSet<Integer> set = new HashSet();
            j = i + 1;
            while (j < sortedNums.length) {
                currentNum = sortedNums[j];
                if (set.contains(-currentTarget - currentNum)) {
                    ans.add(Arrays.asList(currentTarget, currentNum, (-currentTarget - currentNum)));
                    set.add(currentNum);
                    while (j < sortedNums.length && currentNum == sortedNums[j]) {
                        j++;
                    }
                } else {
                    set.add(currentNum);
                    j++;
                }
            }
            while (i < sortedNums.length - 2 && currentTarget == sortedNums[i]) {
                i++;
            }
        }
        return ans;
    }

}


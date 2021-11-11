package org.ianlai.leetcodejava.official.range100;

import java.util.HashMap;

public class LC_official_0001_sumOfTwo {
    public static void main(String[] args) {

    }

    /**
    * twoSumSolution1 使用快排和头尾双指针向中间逼近的方法，时间复杂度为O(nlogn)+2O(n),空间复杂度为O(n),开销为快排后的有序数组存储
    * @author IanLai
    * @date 2021-11-11 17:27:40
    */
    public static int[] twoSumSolution1(int[] nums, int target) {

        int flag_start = 0;
        int flag_end = nums.length - 1;
        int[] tempNums = nums.clone();

        quickSort(tempNums, flag_start, flag_end);

        while (flag_end > flag_start) {
            if (tempNums[flag_start] + tempNums[flag_end] == target) {
                return findIndices(tempNums[flag_start], tempNums[flag_end], nums);
            } else if (tempNums[flag_start] + tempNums[flag_end] > target) {
                flag_end--;
            } else {
                flag_start++;
            }
        }

        return new int[0];
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private static int[] findIndices(int firstValue, int secondValue, int[] nums) {
        int flag = 0;
        int[] result = new int[]{-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == firstValue && result[0] == -1) {
                result[0] = i;
                flag++;
            } else if (nums[i] == secondValue) {
                result[1] = i;
                flag++;
            }
            if (flag == 2)
                break;
        }
        return result;
    }


    /**
     * twoSumSolution2 HashMap处理，时间复杂度为O(n),空间复杂度为O(n),开销为HashMap的开销
     * @author IanLai
     * @date 2021-11-11 17:27:40
     */
    public static int[] twoSumSolution2(int[] nums, int target) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(target - nums[i])){
               return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }
}


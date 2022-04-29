package org.ianlai.leetcodejava.sword;

public class swordToOffer_0021_oddFirstEvenSecond {
    public static void main(String[] args) {

    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     * @author IanLai
     * @date 2022-04-29 17:30:34
     */
    public int[] exchange(int[] nums) {
        int j = nums.length - 1;
        int i = 0;
        int temp;
        while (i < j) {
            while ((nums[i] & 1) == 1 && i != j){
                i++;
            }
            while ((nums[j] & 1) == 0 && i != j){
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}


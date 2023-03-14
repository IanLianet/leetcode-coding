package org.ianlai.leetcodejava.official.range100;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LC_official_0007_reverseInteger {
    public static void main(String[] args) {
        int i = 1534236469;
        int i1 = -123;
        int i2 = -123;

        System.out.println(Math.abs(i1 % 10));
        System.out.println(Math.floorMod(i1, 10));
        System.out.println(reverse(i));
    }

    /*
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


     */
    public static int reverse(int x) {

        int flag = 0;
        if (x == 0) {
            return 0;
        } else if (x > 0) {
            flag = 1;
        } else {
            flag = -1;
        }
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
//        queue.add(Math.abs(x % 10));
//        if(x == Integer.MIN_VALUE){
//            x = Integer.MAX_VALUE / 10;
//        }else{
//            x = Math.abs(x) / 10;
//        }
        while (x != 0) {
            queue.add(Math.abs(x) % 10);
            x = x / 10;
        }
        int value = 0;
        int temp;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.println(poll);
            temp = value;
            value = value * 10 + poll * flag;
            if(temp != value / 10){
                    return 0;
            }
        }
        return value;
    }

}


package org.ianlai.leetcodejava.official.range700;

import java.util.HashMap;
import java.util.Map;

public class LC_official_0629_kInversePairs {

    public static void main(String[] args) {
        Integer result = kInversePairsSolution1(2, 2);
        System.out.println(result);
    }

    public static Integer[][] array = null;


    /*
    * 执行用时：2519 ms, 在所有 Java 提交中击败了5.49%的用户
    * 内存消耗：69.9 MB, 在所有 Java 提交中击败了5.48%的用户
    */
    public static int kInversePairsSolution1(int n, int k) {
        array = new Integer[n+1][k+1];
        return kInversePairsIteration(n, k);
    }

    public static int kInversePairsIteration(int n, int k) {
        int total = 0;
        int start;
        if (k == 0) {
            return 1;
        }
        if (n == 1 && k != 0) {
            return 0;
        }
        if (k - n + 1 > 0) {
            start = k - n + 1;
        } else {
            start = 0;
        }
        for (int i = start; i <= k; i++) {
            if (array[n - 1][i] != null) {
                total = total + array[n - 1][i];
            } else {
                total = total + kInversePairsIteration(n - 1, i);
            }
            while(total >= 1000000000 + 7){
                total = total - (1000000000 + 7);
            }
        }

        array[n][k] = total;
        return total;
    }
}

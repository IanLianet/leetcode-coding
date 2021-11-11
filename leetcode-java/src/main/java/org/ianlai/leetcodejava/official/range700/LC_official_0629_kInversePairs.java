package org.ianlai.leetcodejava.official.range700;

public class LC_official_0629_kInversePairs {

    public static int kInversePairs(int n, int k) {

        int total = 0;
        int start;
        if (k == 0) {
            return 1;
        }
        if (n == 1 && k != 0) {
            return 0;
        }
        if (k - n + 1 > 0) {
            start = k - n;
        } else {
            start = 0;
        }
        for (int i = start; i <= k; i++) {
            total = total + kInversePairs(n - 1, i);
        }
        return total;
    }
}

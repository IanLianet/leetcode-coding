package org.ianlai.leetcodejava.official.range400;

public class LC_official_0400_nth_digit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
        System.out.println(findNthDigit2(2147483647));
    }

    /*
     * 上届爆了估计，所以答案不对，寄了
     */
    public static int findNthDigit(int n) {
        int i = 1;
        while (n > 9 * i * (int)Math.pow(10, (i - 1))) {
            n = n -  9 * i * (int)Math.pow(10, (i - 1));
            i++;
        }
        i--;
        int index = (int) ((n - 1) / i);
        int offset = (int) ((n - 1) % i);
        int number = (int) Math.pow(10, (i - 1)) + index;

        return (int) (String.valueOf(number).charAt(offset) - '0');
    }

    public static int findNthDigit2(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;

    }
}


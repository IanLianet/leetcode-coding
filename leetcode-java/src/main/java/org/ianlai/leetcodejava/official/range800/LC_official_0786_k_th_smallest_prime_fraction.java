package org.ianlai.leetcodejava.official.range800;


import java.util.*;

public class LC_official_0786_k_th_smallest_prime_fraction {
    public static void main(String[] args) {

    }

    /**
     * @author IanLai
     * @date 2021-11-29 16:01:59
     */
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> fractionList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr.length; j++) {
                fractionList.add(new int[]{arr[i], arr[j]});
            }
        Collections.sort(fractionList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] * o2[1] > o1[1] * o2[0]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return fractionList.get(k-1);
    }

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]]);
        for (int j = 1; j < n; ++j) {
            pq.offer(new int[]{0, j});
        }
        for (int i = 1; i < k; ++i) {
            int[] frac = pq.poll();
            int x = frac[0], y = frac[1];
            if (x + 1 < y) {
                pq.offer(new int[]{x + 1, y});
            }
        }
        return new int[]{arr[pq.peek()[0]], arr[pq.peek()[1]]};
    }


}


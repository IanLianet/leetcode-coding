package org.ianlai.leetcodejava.official.range700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_official_0632 {


    /*
        你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。


输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出：[20,24]
解释：
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。

     */
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int[] ints = smallestRange(nums);
        System.out.println(ints[0] + " " + ints[1]);
    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        int n = 0;
        for (List<Integer> integers : nums) {
            n += integers.size();
        }
        int[][] numGroup = new int[n][2];
        int k = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> integers = nums.get(i);
            for (int j = 0; j < integers.size(); j++) {
                numGroup[k] = new int[]{integers.get(j), i};
                k++;
            }
        }
        Arrays.sort(numGroup, (o1, o2) -> (o1[0] - o2[0]));
//        for (int[] perNumGroup : numGroup) {
//            System.out.println(perNumGroup[0] + " " + perNumGroup[1]);
//        }
        int i = 0;
        int j;
        int[] ans = {numGroup[0][0], numGroup[n - 1][0]};
        int[] groupCount = new int[nums.size()];
        int totalCount = 0;
        for (j = 0; j < n; j++) {
            if (groupCount[numGroup[j][1]]++ == 0) {
                totalCount++;
            }
            if (totalCount == nums.size()) {
                while (groupCount[numGroup[i][1]] != 1) {
                    groupCount[numGroup[i][1]]--;
                    i++;
                }
                if ((numGroup[j][0] - numGroup[i][0]) < (ans[1] - ans[0])) {
                    ans[1] = numGroup[j][0];
                    ans[0] = numGroup[i][0];
                }
                groupCount[numGroup[i][1]]--;
                i++;
                totalCount--;
            }
        }

        return ans;
    }


}

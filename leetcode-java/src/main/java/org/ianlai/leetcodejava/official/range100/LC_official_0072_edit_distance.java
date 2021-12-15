package org.ianlai.leetcodejava.official.range100;

public class LC_official_0072_edit_distance {
    public static void main(String[] args) {

    }

    /**
     * 莱文斯坦距离，又称Levenshtein距离，是编辑距离的一种。指两个字串之间，由一个转成另一个所需的最少编辑操作次数。
     * DP
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int count;
        int[][] levenshteinDistance = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            levenshteinDistance[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            levenshteinDistance[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    count = 0;
                else
                    count = 1;
                levenshteinDistance[i][j] = Math.min(levenshteinDistance[i-1][j] + 1,
                        Math.min(levenshteinDistance[i][j-1] + 1,levenshteinDistance[i-1][j-1] + count));
            }
        }

        return levenshteinDistance[m][n];
    }

    public int minDistance2(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] array = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            array[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            array[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    array[i][j] = array[i - 1][j - 1] + 1;
                else
                    array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]);
            }
        }

        return Math.max(m - array[m][n], n - array[m][n]);
    }
}


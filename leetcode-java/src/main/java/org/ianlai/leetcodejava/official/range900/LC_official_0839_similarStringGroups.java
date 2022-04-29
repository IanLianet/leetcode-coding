package org.ianlai.leetcodejava.official.range900;

public class LC_official_0839_similarStringGroups {

    public static void main(String[] args) {

        String[] string = {"aa"};
        int result = numSimilarGroups(string);
        System.out.println(result);
    }

    /*
    * 并查集 解决连通图问题
    *
    * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
    * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
    * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。
    * 形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
    * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
    * 示例 1：
    * 输入：strs = ["tars","rats","arts","star"]
    * 输出：2
    *
    * 示例 2：
    * 输入：strs = ["omv","ovm"]
    * 输出：1
    */
    public static int numSimilarGroups(String[] strs) {
        return 0;
    }

}

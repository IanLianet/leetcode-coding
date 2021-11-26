package org.ianlai.leetcodejava.official.range700;

public class LC_official_0700_searchInABinarySearchTree {

    public static void main(String[] args) {

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了72.05%的用户
     *
     * @author IanLai
     * @date 2021-11-26 15:48:52
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.val < val)
            return searchBST(root.right, val);
        return searchBST(root.left, val);
    }

}

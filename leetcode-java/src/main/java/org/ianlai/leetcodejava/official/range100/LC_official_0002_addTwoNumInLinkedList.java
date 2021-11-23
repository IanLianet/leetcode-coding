package org.ianlai.leetcodejava.official.range100;

public class LC_official_0002_addTwoNumInLinkedList {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
     * 执行用时：2 ms, 在所有 Java 提交中击败了89.57%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了22.34%的用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int step = 0;
        int sum = 0;
        ListNode resultHeadNode = new ListNode(-1);
        ListNode nowNode = resultHeadNode;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + step;
            ListNode newNode = new ListNode(sum % 10);
            nowNode.next = newNode;
            nowNode = newNode;
            step = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            l1 = l2;
        }

        while (l1 != null) {
            sum = l1.val + step;
            ListNode newNode = new ListNode(sum % 10);
            nowNode.next = newNode;
            nowNode = newNode;
            step = sum / 10;
            l1 = l1.next;
        }

        if (step != 0) {
            nowNode.next = new ListNode(step);
        }

        return resultHeadNode.next;
    }
}


package com.google.linkedlist;

public class Leet2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int increase = 0;
        ListNode root = new ListNode();
        ListNode node = root;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) v1 = l1.val;
            if (l2 != null) v2 = l2.val;
            int sum = v1 + v2 + increase;
            if (sum > 9) {
                increase = 1;
            } else {
                increase = 0;
            }
            node.next = new ListNode(sum % 10);
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (increase == 1) {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(1);
        }
        return root.next;
    }
}

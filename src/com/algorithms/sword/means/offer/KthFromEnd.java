package com.algorithms.sword.means.offer;

public class KthFromEnd {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode later = head;
        for (int i = 0; i < k; i++) {
            later = later.next;
        }
        while (later != null) {
            later = later.next;
            former = former.next;
        }
        return former;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        getKthFromEnd(l1, 2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

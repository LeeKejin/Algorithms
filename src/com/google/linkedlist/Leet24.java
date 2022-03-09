package com.google.linkedlist;

public class Leet24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;

        while (fast != null && fast.next != null) {
            ListNode next1 = fast.next;
            ListNode next2 = fast.next.next;
            slow.next = next1;
            next1.next = fast;
            fast.next = next2;
            slow = fast;
            fast = fast.next;

        }
        return dummy.next;

    }
}

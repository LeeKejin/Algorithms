package com.google.linkedlist;

public class Leet19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

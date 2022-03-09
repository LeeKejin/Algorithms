package com.amazon.interview;

public class Leet25 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int count = 0;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (count % k == 0) {
                prev = reverse(prev, cur.next);
                cur = prev.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode cur = start.next;
        ListNode first = start.next;
        while (cur != end) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        first.next = end;
        start.next = prev;
        return first;
    }
}

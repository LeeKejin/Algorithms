package com.algorithms.sort.amazon;

public class Leet147 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val >= cur.val) {
                cur = next;
                next = cur.next;
            } else {
                cur.next = next.next;
                process(dummyHead, next);
                next = cur.next;
            }
        }
        return dummyHead.next;
    }

    private void process(ListNode dummyHead, ListNode node) {
        ListNode prev = dummyHead;
        ListNode cur = dummyHead.next;

        while (cur != null) {
            if (cur.val > node.val) {
                prev.next = node;
                node.next = cur;
                break;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
    }
}

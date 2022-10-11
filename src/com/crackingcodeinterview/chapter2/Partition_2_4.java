package com.crackingcodeinterview.chapter2;

import com.crackingcodeinterview.util.ListNode;


public class Partition_2_4 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode node = head;
        while (node != null && node.val != x) {
            node = node.next;
        }
        ListNode prev = node;
        if (prev == null) {
            prev = new ListNode();
            prev.next = head;
            node = head;
        }
        while (node != null) {
            if (node.val < x) {
                ListNode newHead = new ListNode(node.val);
                newHead.next = head;
                head = newHead;
                prev.next = node.next;
                node = prev.next;
            } else {
                prev = node;
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        Partition_2_4 partition_2_4 = new Partition_2_4();
        partition_2_4.partition(head, 3);
    }
}

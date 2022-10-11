package com.crackingcodeinterview.chapter2;

import com.crackingcodeinterview.util.ListNode;

public class AddTwoNumbers_2_5 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        int c = 0;
        ListNode prev = l1;
        while (n1 != null && n2 != null) {
            int sum = n1.val + n2.val + c;
            if (sum < 10) {
                n1.val = sum;
                n2.val = sum;
                c = 0;
            } else {
                n1.val = sum % 10;
                n2.val = sum % 10;
                c = 1;
            }
            prev = n1;
            n1 = n1.next;
            n2 = n2.next;
        }
        ListNode node;
        ListNode head;

        if (n1 == null) {
            head = l2;
            node = n2;
        } else {
            head = l1;
            node = n1;
        }
        if (node == null && c == 1) {
            prev.next = new ListNode(1);
            return l1;
        }
        while (node != null) {
            int sum = node.val + c;
            if (sum < 10) {
                node.val = sum;
                break;
            } else {
                node.val = sum % 10;
                c = 1;
                if (node.next == null) {
                    node.next = new ListNode(1);
                    break;
                }
            }
            node = node.next;
        }
        return head;
    }
}

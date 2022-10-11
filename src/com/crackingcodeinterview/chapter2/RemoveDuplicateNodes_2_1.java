package com.crackingcodeinterview.chapter2;


import com.crackingcodeinterview.util.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateNodes_2_1 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode prev = head;
        ListNode node = head.next;
        while (node != null) {
            if (set.contains(node.val)) {
                prev.next = node.next;
                node = prev.next;
            } else {
                set.add(node.val);
                prev = node;
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicateNodes_2_1 test = new RemoveDuplicateNodes_2_1();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        test.removeDuplicateNodes(head);
    }
}

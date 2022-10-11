package com.crackingcodeinterview.chapter2;

import com.crackingcodeinterview.util.ListNode;

public class DeleteNode_2_3 {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

package com.crackingcodeinterview.chapter4;

import com.crackingcodeinterview.util.ListNode;
import com.google.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepth_4_3 {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = new ListNode(-1);
            ListNode prev = head;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ListNode listNode = new ListNode(node.val);
                prev.next = listNode;
                prev = listNode;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(head.next);

        }
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

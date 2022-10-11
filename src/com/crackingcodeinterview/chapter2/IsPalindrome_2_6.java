package com.crackingcodeinterview.chapter2;

import com.crackingcodeinterview.util.ListNode;


public class IsPalindrome_2_6 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            ListNode oldCur = slow;

            slow = slow.next;
            fast = fast.next.next;

            oldCur.next = prev;
            prev = oldCur;
        }
        if (fast == null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome_2_6 isPalindrome_2_6 = new IsPalindrome_2_6();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        isPalindrome_2_6.isPalindrome(head);
    }
}

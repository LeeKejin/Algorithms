package com.algorithms.link.leetcode;

public class Leet206
{
    public ListNode reverseList( ListNode head )
    {
        if ( head == null ) return null;
        ListNode cur = head;
        ListNode prev = null;
        while ( cur != null )
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;

        }
        return prev;
    }

    public class ListNode
    {
        int val;
        ListNode next;

        ListNode( int x )
        {
            val = x;
        }
    }
}

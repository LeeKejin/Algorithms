package com.algorithms.link.leetcode;

public class Leet206
{
    public ListNode reverseList( ListNode head )
    {
        if ( head == null ) return null;
        ListNode prev = null;
        ListNode cur = head;
        while ( cur.next != null )
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        cur.next = prev;
        return cur;
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

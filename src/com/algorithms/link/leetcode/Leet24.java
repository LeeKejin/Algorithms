package com.algorithms.link.leetcode;

public class Leet24
{
    public ListNode swapPairs( ListNode head )
    {
        ListNode dummyHead = new ListNode( -1 );
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while ( prev.next != null && prev.next.next != null )
        {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first.next;
        }
        return dummyHead.next;
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

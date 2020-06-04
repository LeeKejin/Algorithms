package com.algorithms.link.leetcode;

public class Leet203
{
    public static ListNode removeElements( ListNode head, int val )
    {
        while ( head != null && head.val == val )
        {
            head = head.next;
        }
        if ( head == null ) return head;
        ListNode cur = head.next;
        ListNode prev = null;
        while ( cur != null )
        {
            if ( cur.val == val )
            {
                if ( prev == null )
                {
                    head.next = cur.next;
                    cur = cur.next;
                    continue;
                }
                else
                {
                    prev.next = cur.next;
                    cur = cur.next;
                    continue;
                }
            }
            else
            {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }

    public static ListNode removeElementsWithDummyHead( ListNode head, int val )
    {
        ListNode dummyHead = new ListNode( -1 );
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while ( prev.next != null )
        {
            if ( prev.next.val == val )
            {
                prev.next = prev.next.next;
                continue;
            }
            prev = prev.next;
        }
        return dummyHead.next;
    }

    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode( int x )
        {
            val = x;
        }
    }

    public static void main( String[] args )
    {
        ListNode l1 = new ListNode( 1 );
        //        ListNode l2 = new ListNode( 2 );
        l1.next = null;
        //        l2.next = null;
        removeElements( l1, 1 );
    }
}

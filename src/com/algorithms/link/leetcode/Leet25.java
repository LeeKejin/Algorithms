package com.algorithms.link.leetcode;

public class Leet25
{
    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode( int x )
        {
            val = x;
        }
    }

    public static ListNode reverseKGroup( ListNode head, int k )
    {
        if ( head == null || k <= 1 ) return head;
        ListNode dummyHead = new ListNode( -1 );
        dummyHead.next = head;
        ListNode cur = dummyHead.next;
        ListNode prev = dummyHead;
        int count = 0;
        while ( cur != null )
        {
            count++;
            if ( count % k == 0 )
            {

                prev = reverse( prev, cur.next );
                cur = prev.next;
            }
            else
            {

                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode reverse( ListNode start, ListNode end )
    {
        ListNode prev = start;
        ListNode cur = start.next;
        ListNode first = start.next;

        while ( cur != end )
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        start.next = prev;
        first.next = end;
        return first;

    }

    public static void main( String[] args )
    {
        ListNode l1 = new ListNode( 1 );
        ListNode l2 = new ListNode( 2 );
        ListNode l3 = new ListNode( 3 );
        ListNode l4 = new ListNode( 4 );
        //        ListNode l2 = new ListNode( 2 );
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        reverseKGroup( l1, 3 );
    }
}
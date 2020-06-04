package com.algorithms.link.leetcode;

public class Leet92
{
    public static ListNode reverseBetween( ListNode head, int m, int n )
    {
        ListNode cur = head;
        int count = n - m;
        int c = 0;

        ListNode prev = null;
        while ( cur != null )
        {
            if ( c == m - 1 )
            {
                break;
            }
            prev = cur;
            cur = cur.next;
            c++;
        }
        ListNode newPrev = null;
        ListNode last = null;
        while ( count >= 0 )
        {
            if ( count == 0 )
            {
                last = cur.next;
            }
            ListNode next = cur.next;
            cur.next = newPrev;
            newPrev = cur;
            cur = next;
            count--;
        }
        if ( prev != null )
        {
            prev.next = newPrev;
            ListNode newcur = head;
            while ( newcur.next != null )
            {
                newcur = newcur.next;
            }

            newcur.next = last;
            return head;
        }
        else
        {
            ListNode newcur = newPrev;
            while ( newcur.next != null )
            {
                newcur = newcur.next;
            }

            newcur.next = last;
            return newPrev;
        }

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
        ListNode l1 = new ListNode( 2 );
        ListNode l2 = new ListNode( 1 );
        ListNode l3 = new ListNode( 3 );
        //        ListNode l4 = new ListNode( 4 );
        //        ListNode l5 = new ListNode( 5 );
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        //        l4.next = l5;
        //        l5.next = null;
        reverseBetween( l1, 1, 2 );
    }

}

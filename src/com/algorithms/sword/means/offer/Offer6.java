package com.algorithms.sword.means.offer;

public class Offer6
{
    public static int[] reversePrint( ListNode head )
    {
        ListNode dummyHead = new ListNode( -1 );
        dummyHead.next = head;
        ListNode cur = dummyHead.next;
        int count = 0;
        while ( cur != null )
        {
            cur = cur.next;
            count++;
        }
        cur = dummyHead.next;
        int[] arr = new int[ count ];
        while ( cur != null )
        {
            count--;
            arr[ count ] = cur.val;
            cur = cur.next;

        }
        return arr;
    }

    public static void main( String[] args )
    {
        ListNode l1 = new ListNode( 1 );
        ListNode l2 = new ListNode( 3 );
        ListNode l3 = new ListNode( 2 );
        l1.next = l2;
        l2.next = l3;
        int[] sum = reversePrint( l1 );
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
}

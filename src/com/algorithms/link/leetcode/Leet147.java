package com.algorithms.link.leetcode;

public class Leet147
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

    public static ListNode insertionSortList( ListNode head )
    {
        ListNode dummyHead = new ListNode( Integer.MIN_VALUE );
        dummyHead.next = head;
        ListNode cur = dummyHead.next;

        while ( cur != null )
        {

            insert( cur, dummyHead, cur.next );

            cur = cur.next;
        }
        return head;
    }

    public static void insert( ListNode node, ListNode head, ListNode end )
    {
        ListNode cur = head.next;
        ListNode prev = head;
        while ( cur.val != end.val )
        {
            if ( node.val < cur.val )
            {
                ListNode temp = node.next;
                prev.next = node;
                node.next = cur;
                cur.next = temp;
                break;
            }
            else
            {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public static void main( String[] args )
    {
        ListNode l1 = new ListNode( 4 );
        ListNode l2 = new ListNode( 2 );
        ListNode l3 = new ListNode( 1 );
        ListNode l4 = new ListNode( 3 );
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        insertionSortList( l1 );
    }
}

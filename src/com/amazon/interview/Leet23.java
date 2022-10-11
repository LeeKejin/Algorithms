package com.amazon.interview;

import java.util.PriorityQueue;
//mergeKLists
public class Leet23
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

    public ListNode mergeKLists( ListNode[] lists )
    {
        if ( lists.length == 0 ) return null;
        return merge( lists, 0, lists.length - 1 );
    }

    private ListNode merge( ListNode[] lists, int start, int end )
    {
        if ( start == end ) return lists[ start ];
        int mid = start + ( end - start ) / 2;
        ListNode l1 = merge( lists, start, mid );
        ListNode l2 = merge( lists, mid + 1, end );

        return mergeTwoList( l1, l2 );
    }

    private ListNode mergeTwoList( ListNode l1, ListNode l2 )
    {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        if ( l1.val < l2.val )
        {
            l1.next = mergeTwoList( l1.next, l2 );
            return l1;
        }
        l2.next = mergeTwoList( l1, l2.next );
        return l2;
    }

    public ListNode mergeKListsHeap( ListNode[] lists )
    {
        if ( lists.length == 0 ) return null;
        if ( lists.length < 2 ) return lists[ 0 ];
        PriorityQueue< ListNode > queue = new PriorityQueue<>( ( n1, n2 ) -> ( n1.val - n2.val ) );
        for ( ListNode list : lists )
        {
            if ( list != null ) queue.add( list );
        }
        ListNode head = null;
        ListNode last = null;
        while ( !queue.isEmpty() )
        {
            ListNode node = queue.poll();
            if ( head == null )
            {
                head = node;
                last = node;
            }
            else
            {
                last.next = node;
                last = last.next;
            }

            if ( node.next != null ) queue.add( node.next );
        }
        return head;
    }
}

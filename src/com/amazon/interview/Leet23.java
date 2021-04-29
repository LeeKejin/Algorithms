package com.amazon.interview;

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
}

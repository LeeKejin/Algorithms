package com.algorithms.sword.means.offer;

public class Offer22
{
    public ListNode getKthFromEnd( ListNode head, int k )
    {
        if ( head == null ) return null;
        ListNode node = head;
        int count = 0;
        while ( node != null )
        {
            count++;
            node = node.next;
        }
        int n = count - k;
        if ( n < 0 ) return head;
        node = head;
        while ( n >= 0 )
        {
            node = node.next;
            n--;
        }
        return node;
    }

    public ListNode getKthFromEnd1( ListNode head, int k )
    {
        if ( head == null ) return null;
        ListNode start = head;
        ListNode end = head;
        while ( k > 0 )
        {
            k--;
            end = end.next;
        }
        while ( end != null )
        {
            start = start.next;
            end = end.next;
        }
        return start;
    }

}

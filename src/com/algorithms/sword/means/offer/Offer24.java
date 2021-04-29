package com.algorithms.sword.means.offer;

public class Offer24
{
    public ListNode reverseList( ListNode head )
    {
        if ( head == null ) return null;
        ListNode node = head;
        ListNode prev = null;
        while ( node != null )
        {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}

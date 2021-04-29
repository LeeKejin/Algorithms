package com.algorithms.sword.means.offer;

public class Offer25_C
{
    public ListNode mergeTwoLists( ListNode l1, ListNode l2 )
    {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode dummy = new ListNode( 0 );
        ListNode cur = dummy;
        while ( n1 != null && n2 != null )
        {
            if ( n1.val < n2.val )
            {
                cur.next = n1;
                n1 = n1.next;
            }
            else
            {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if ( n1 == null )
        {
            cur.next = n1;

        }
        else
        {
            cur.next = n2;
        }
        return dummy.next;
    }

}

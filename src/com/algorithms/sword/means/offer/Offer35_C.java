package com.algorithms.sword.means.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer35_C
{
    class Node
    {
        int val;
        Node next;
        Node random;

        public Node( int val )
        {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //time O(1) space O(n)
    public Node copyRandomList( Node head )
    {
        if ( head == null ) return null;
        Map< Node, Node > map = new HashMap<>();
        Node node = head;
        while ( node != null )
        {
            map.put( node, new Node( node.val ) );
            node = node.next;
        }
        node = head;
        while ( node != null )
        {
            map.get( node ).next = map.get( node.next );
            map.get( node ).random = map.get( node.random );
            node = node.next;
        }
        return map.get( head );
    }

    //time O(1) space O(1)
    public Node copyRandomList1( Node head )
    {
        if ( head == null ) return null;
        Node node = head;
        while ( node != null )
        {
            Node newNode = new Node( node.val );
            Node next = node.next;
            node.next = newNode;
            newNode.next = next;
            node = node.next.next;
        }
        node = head;
        while ( node != null )
        {
            if ( node.random != null && node.next != null )
            {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head;
        Node res = head.next;
        Node cur = head.next;
        while ( node.next.next != null )
        {

            node.next = node.next.next;
            cur.next = cur.next.next;

            cur = cur.next;
            node = node.next;
        }
        node.next = null;
        return res;
    }
}

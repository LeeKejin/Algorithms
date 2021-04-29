package com.algorithms.binary.search.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet117
{
    class Node
    {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node()
        {
        }

        public Node( int _val )
        {
            val = _val;
        }

        public Node( int _val, Node _left,
            Node _right,
            Node _next )
        {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect( Node root )
    {
        if ( root == null ) return null;
        Queue< Node > queue = new LinkedList<>();
        queue.add( root );
        while ( !queue.isEmpty() )
        {
            int size = queue.size();

            for ( int i = 0; i < size; i++ )
            {
                Node node = queue.poll();
                if ( i + 1 == size )
                {
                    node.next = null;
                }
                else
                {
                    node.next = queue.peek();
                }
                if ( node.left != null ) queue.add( node.left );
                if ( node.right != null ) queue.add( node.right );
            }
        }
        return root;
    }

    public Node connectBetterSolution( Node root )
    {
        if ( root == null ) return null;
        Node cur = root;

        while ( cur != null )
        {
            Node dummy = cur;
            Node prev = new Node( 0 );

            while ( cur != null )
            {
                if ( cur.left != null )
                {
                    prev.next = cur.left;
                    prev = prev.next;
                }
                if ( cur.right != null )
                {
                    prev.next = cur.right;
                    prev = prev.next;
                }
                cur = cur.next;
            }
            cur = findCur( dummy );
        }
        return root;
    }

    private Node findCur( Node dummy )
    {
        if ( dummy.left != null ) return dummy.left;
        if ( dummy.right != null ) return dummy.right;
        if ( dummy.next != null ) return findCur( dummy.next );
        return null;
    }
}

package com.algorithms.binary.search.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet116
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

        public Node( int _val, Node _left, Node _right, Node _next )
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

                if ( i != size - 1 )
                {
                    node.next = queue.peek();
                }
                else
                {
                    node.next = null;
                }
                if ( node.left != null ) queue.add( node.left );

                if ( node.right != null ) queue.add( node.right );

            }

        }
        return root;
    }

    ////////////////////////////////////////////////////////////////////
    public Node connectWithRecursive( Node root )
    {
        if ( root == null ) return null;

        findNext( root.left, root.right );
        return root;
    }

    private void findNext( Node left, Node right )
    {
        if ( left == null || right == null ) return;
        left.next = right;
        findNext( left.right, right.left );
        findNext( left.left, left.right );
        findNext( right.left, right.right );
    }
}

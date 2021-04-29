package com.amazon.interview;

public class Leet426
{
    class Node
    {
        public int val;
        public Node left;
        public Node right;

        public Node()
        {
        }

        public Node( int _val )
        {
            val = _val;
        }

        public Node( int _val, Node _left, Node _right )
        {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node first = null;
    Node prev = null;

    public Node treeToDoublyList( Node root )
    {
        if ( root == null ) return null;
        helper( root );
        first.left = prev;
        prev.right = first;
        return first;
    }

    private void helper( Node node )
    {
        if ( node == null ) return;
        helper( node.left );
        if ( first == null )
        {
            first = node;
        }
        if ( prev == null )
        {
            prev = node;
        }
        else
        {
            prev.right = node;
            node.left = prev;
            prev = node;
        }

        helper( node.right );
    }
}

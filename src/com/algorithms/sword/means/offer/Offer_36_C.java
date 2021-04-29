package com.algorithms.sword.means.offer;

public class Offer_36_C
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
    Node last = null;

    public Node treeToDoublyList( Node root )
    {
        if ( root == null ) return null;
        helper( root );
        first.left = last;
        last.left = first;
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
        if ( last == null )
        {
            last = node;
        }
        else
        {
            last.right = node;
            node.left = last;
            last = node;
        }
        helper( node.right );
    }

    public static void main( String[] args )
    {
        Offer_36_C t = new Offer_36_C();
        t.test();
    }

    public void test()
    {
        Node root = new Node( 4 );
        Node n2 = new Node( 2 );
        Node n1 = new Node( 1 );
        Node n3 = new Node( 3 );
        Node n5 = new Node( 5 );

        root.left = n2;
        root.right = n5;
        n2.left = n1;
        n2.right = n3;
        treeToDoublyList( root );
    }
}

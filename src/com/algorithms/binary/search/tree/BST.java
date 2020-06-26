package com.algorithms.binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST< E extends Comparable< E > >
{
    private class Node
    {
        public E e;
        public Node left;
        public Node right;

        public Node( E e )
        {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST()
    {
        root = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( E e )
    {
        root = add( root, e );
    }

    private Node add( Node node, E e )
    {
        if ( node == null )
        {
            size++;
            return new Node( e );
        }

        if ( e.compareTo( node.e ) < 0 )
        {
            node.left = add( node.left, e );
        }
        else if ( e.compareTo( node.e ) > 0 )
        {
            node.right = add( node.right, e );
        }
        return node;
    }

    public boolean contains( E e )
    {
        return contains( root, e );
    }

    private boolean contains( Node node, E e )
    {
        if ( node == null ) return false;
        if ( e.compareTo( node.e ) == 0 ) return true;
        if ( e.compareTo( node.e ) < 0 ) return contains( node.left, e );
        return contains( node.right, e );
    }

    public void preOrder()
    {
        preOrder( root );
    }

    private void preOrder( Node node )
    {
        if ( node != null )
        {
            System.out.println( node.e );
            preOrder( node.left );
            preOrder( node.right );
        }
    }

    //tree will be sorted
    public void inOrder()
    {
        inOrder( root );
    }

    private void inOrder( Node node )
    {
        if ( node == null ) return;
        inOrder( node.left );
        System.out.println( node.e );
        inOrder( node.right );
    }

    public void postOrder()
    {
        postOrder( root );
    }

    private void postOrder( Node node )
    {
        if ( node == null ) return;
        postOrder( node.left );
        postOrder( node.right );
        System.out.println( node.e );
    }

    public void preOrderWithoutRecursion()
    {
        Stack< Node > stack = new Stack<>();

        stack.push( root );
        while ( !stack.empty() )
        {
            Node cur = stack.pop();
            System.out.println( cur.e );
            if ( cur.right != null ) stack.push( cur.right );
            if ( cur.left != null ) stack.push( cur.left );
        }
    }

    public void retrieveByLayer()
    {
        Queue< Node > queue = new LinkedList<>();
        queue.add( root );
        while ( !queue.isEmpty() )
        {
            Node cur = queue.poll();
            System.out.println( cur.e );
            if ( cur.left != null ) queue.add( cur.left );
            if ( cur.right != null ) queue.add( cur.right );
        }
    }

    public E minimumWithoutRecursion()
    {
        Node node = root;

        while ( node.left != null )
        {
            node = node.left;

        }
        E val = node.e;
        return val;
    }

    public E minimum()
    {
        return minimum( root );
    }

    private E minimum( Node node )
    {
        if ( node.left != null )
        {
            return minimum( node.left );
        }
        E val = node.e;
        return val;
    }

    public E removeMin()
    {
        E res = minimum( root );
        root = removeMin( root );
        return res;
    }

    private Node removeMin( Node node )
    {
        if ( node.left == null )
        {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin( node.left );
        return node;
    }

    public void removeNode( E e )
    {
        root = removeNode( root, e );
    }

    private Node removeNode( Node node, E e )
    {
        if ( node == null ) return null;
        if ( e.compareTo( node.e ) < 0 )
        {
            node.left = removeNode( node.left, e );
            return node;
        }
        else if ( e.compareTo( node.e ) > 0 )
        {
            node.right = removeNode( node.right, e );
            return node;
        }
        if ( node.right == null )
        {
            size--;
            return node.left;
        }
        if ( node.left == null )
        {
            size--;
            return node.right;
        }
        E val = minimum( node.right );
        Node successor = new Node( val );
        successor.left = node.left;
        successor.right = removeMin( node.right );
        return successor;

    }
}

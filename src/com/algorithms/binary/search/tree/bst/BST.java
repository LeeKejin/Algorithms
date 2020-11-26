package com.algorithms.binary.search.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST< E extends Comparable< E > >
{
    public class Node
    {
        Node right;
        Node left;
        public E e;

        public Node( E e )
        {
            this.e = e;
            right = null;
            left = null;
        }
    }

    Node root;
    int size;

    public BST()
    {
        root = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public Node getRoot()
    {
        return root;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( E e )
    {
        if ( isEmpty() )
        {
            root = new Node( e );
            size++;
        }
        else
        {
            add( e, root );
            //            addWithoutRecrusion( e );
        }

    }

    private Node add( E e, Node node )
    {
        if ( node == null )
        {
            size++;
            return new Node( e );
        }

        if ( e.compareTo( node.e ) < 0 )
        {
            node.left = add( e, node.left );
        }
        else if ( e.compareTo( node.e ) > 0 )
        {
            node.right = add( e, node.right );
        }
        return node;
    }

    private void addWithoutRecrusion( E e )
    {

        Node node = root;
        while ( node != null )
        {
            if ( e.compareTo( node.e ) < 0 )
            {
                if ( node.left == null )
                {
                    node.left = new Node( e );
                    size++;
                    return;
                }
                else
                {
                    node = node.left;
                }
            }
            else if ( e.compareTo( node.e ) > 0 )
            {
                if ( node.right == null )
                {
                    node.right = new Node( e );
                    size++;
                    return;
                }
                else
                {
                    node = node.right;
                }
            }
            else
            {
                return;
            }
        }

    }

    public E findElement( E e )
    {
        return findElement( e, root );
    }

    private E findElement( E e, Node node )
    {
        if ( node == null ) return null;
        if ( e.compareTo( node.e ) == 0 ) return node.e;
        if ( e.compareTo( node.e ) < 0 ) return findElement( e, node.left );
        return findElement( e, node.right );
    }

    public void preOrderRetrieve()
    {
        preOrderRetrieve( root );
    }

    private void preOrderRetrieve( Node node )
    {
        if ( node == null ) return;
        System.out.println( node.e );
        preOrderRetrieve( node.left );
        preOrderRetrieve( node.right );
    }

    public void preOrderRetrieveWithOutRecrusion()
    {
        Stack< Node > stack = new Stack<>();
        if ( root == null ) return;
        stack.push( root );
        while ( !stack.isEmpty() )
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
        if ( root == null ) return;
        queue.add( root );
        while ( !queue.isEmpty() )
        {
            Node cur = queue.poll();
            System.out.println( cur.e );
            if ( cur.left != null ) queue.add( cur.left );
            if ( cur.right != null ) queue.add( cur.right );
        }
    }

    public void removeMin()
    {
        if ( root == null ) return;
        removeMin( root );
    }

    public void removeMax()
    {
        if ( root == null ) return;
        removeMax( root );
    }

    private Node removeMin( Node node )
    {
        if ( node.left != null )
        {
            node.left = removeMin( node.left );
            return node;
        }
        size--;
        return node.right;
    }

    private Node removeMax( Node node )
    {
        if ( node.right != null )
        {
            node.right = removeMax( node.right );
            return node;
        }
        size--;
        return node.left;
    }

    public E findMinimum()
    {
        if ( root == null ) return null;
        return findMinimum( root ).e;
    }

    private Node findMinimum( Node node )
    {
        if ( node.left == null ) return node;
        return findMinimum( node.left );
    }

    public void remove( E e )
    {
        remove( e, root );
    }

    private Node remove( E e, Node node )
    {
        if ( node == null ) return null;
        if ( e.compareTo( node.e ) < 0 )
        {
            node.left = remove( e, node.left );
            return node;
        }
        else if ( e.compareTo( node.e ) > 0 )
        {
            node.right = remove( e, node.right );
            return node;
        }

        if ( node.left == null )
        {
            size--;
            return node.right;
        }

        if ( node.right == null )
        {
            size--;
            return node.left;
        }
        E min = findMinimum( node.right ).e;
        removeMin( node.right );
        Node newNode = new Node( min );
        newNode.left = node.left;
        newNode.right = node.right;
        return newNode;

    }

    public static void main( String[] args )
    {
        BST< Integer > bts = new BST<>();
        int[] nums = { 41, 22, 58, 33, 50, 60, 37, 42, 53, 59, 63 };
        for ( int num : nums )
        {
            bts.add( num );
        }
        bts.retrieveByLayer();
        bts.remove( 58 );
        System.out.println( "------------------------------" );
        bts.retrieveByLayer();
    }
}

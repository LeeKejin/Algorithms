package com.algorithms.link.structure;

public class LinkedList< E >
{
    private class Node
    {
        public E e;
        public Node next;

        public Node( E e, Node next )
        {
            this.e = e;
            this.next = next;
        }

        public Node( E e )
        {
            this( e, null );
        }

        public Node()
        {
            this( null, null );
        }

        @Override
        public String toString()
        {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList()
    {
        dummyHead = new Node( null, null );
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    //It's easy to insert value in head of linklist
    public void addFirst( E e )
    {
        add( 0, e );
    }

    public void add( int index, E e )
    {
        Node node = new Node( e );
        Node prev = dummyHead; //find the previous node, retrieving via dummyhead
        for ( int i = 0; i < index; i++ )
        {
            prev = prev.next;
        }

        Node next = prev.next;
        prev.next = node;
        node.next = next;
        size++;
    }

    public void addLast( E e )
    {
        add( size, e );
    }

    public E getNode( int index )
    {
        Node cur = dummyHead.next; //find the previous node, retrieving via dummyhead.next
        for ( int i = 0; i < index; i++ )
        {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst()
    {
        return getNode( 0 );
    }

    public E getLast()
    {
        return getNode( size - 1 );
    }

    public void set( int index, E e )
    {
        Node cur = dummyHead.next;
        for ( int i = 0; i < index; i++ )
        {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains( E e )
    {
        Node cur = dummyHead.next;
        for ( int i = 0; i < size; i++ )
        {
            if ( cur.e.equals( e ) ) return true;
            cur = cur.next;
        }

        return false;
    }

    public E deleteNode( E e )
    {
        if ( !contains( e ) ) throw new RuntimeException( "Not exist!" );
        Node prev = dummyHead;
        Node cur = prev.next;
        for ( int i = 0; i < size; i++ )
        {
            cur = prev.next;
            if ( cur.e.equals( e ) ) break;
            prev = cur;
        }
        prev.next = cur.next;
        return e;
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while ( cur != null )
        {
            res.append( cur + "=>" );
            cur = cur.next;
        }
        res.append( "NULL" );
        return res.toString();
    }
}

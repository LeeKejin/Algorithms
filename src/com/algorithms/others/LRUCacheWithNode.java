package com.algorithms.others;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheWithNode
{
    class Node
    {
        int key;
        int val;
        Node prev;
        Node next;

        public Node( int key, int val )
        {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Node head;
    Node tail;
    Map< Integer, Node > map = new HashMap<>();

    public LRUCacheWithNode( int capacity )
    {
        this.capacity = capacity;
        head = new Node( 0, 0 );
        tail = new Node( 0, 0 );
        head.next = tail;
        tail.prev = head;
    }

    public int get( int key )
    {
        if ( !map.containsKey( key ) ) return -1;
        Node node = map.get( key );
        int val = node.val;
        removeNode( node );
        moveNodeToTail( node );
        return val;
    }

    private void moveNodeToTail( Node node )
    {
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        node.prev = prev;
        tail.prev = node;
    }

    private void removeNode( Node node )
    {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    public void put( int key, int value )
    {
        if ( map.size() < capacity )
        {
            if ( map.containsKey( key ) )
            {
                Node node = map.get( key );
                node.val = value;
                removeNode( node );
                moveNodeToTail( node );
                map.put( key, node );
            }
            else
            {
                Node node = new Node( key, value );
                moveNodeToTail( node );
                map.put( key, node );
            }

        }
        else
        {
            if ( map.containsKey( key ) )
            {
                Node node = map.get( key );
                node.val = value;
                removeNode( node );
                moveNodeToTail( node );
                map.put( key, node );

            }
            else
            {
                Node node = new Node( key, value );
                map.remove( head.next.key );
                removeNode( head.next );

                moveNodeToTail( node );
                map.put( key, node );
            }
        }
    }
}
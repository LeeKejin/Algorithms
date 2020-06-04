package com.algorithms.others;

import java.util.HashMap;

public class LRUCacheWithNode
{
    HashMap< Integer, Node > map;
    int capacity;
    Node head;
    Node tail;

    public LRUCacheWithNode( int capacity )
    {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get( int key )
    {
        if ( map.containsKey( key ) )
        {
            Node node = map.get( key );
            moveNodeToTail( node );
            return node.value;
        }
        return -1;
    }

    public void put( int key, int value )
    {
        if ( map.containsKey( key ) )
        {
            Node node = map.get( key );
            node.value = value;
            moveNodeToTail( node );
        }
        else
        {
            Node node = new Node( key, value );

            if ( map.size() >= capacity )
            {
                removeHead();
            }
            if ( head == null )
            {
                head = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                node.prev = tail;
                tail = node;
                tail.next = null;

            }
            map.put( key, node );
        }
    }

    private void removeHead()
    {
        map.remove( head.key );
        if ( head.next == null )
        {
            head = null;
        }
        else
        {
            head.next.prev = null;
            head = head.next;
        }
    }

    private void moveNodeToTail( Node node )
    {
        if ( tail == node ) return;
        if ( head == null || tail == null )
        {
            head = node;
            tail = node;
        }
        else if ( node == head )
        {
            head.next.prev = null;
            head = head.next;
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
        else
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
    }

    class Node
    {
        int key;
        int value;
        Node prev;
        Node next;

        Node( int key, int value )
        {
            this.key = key;
            this.value = value;
        }
    }

}

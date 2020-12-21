package com.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap
{
    private List< Integer > list = new ArrayList<>();

    public MaxHeap( List< Integer > list )
    {
        this.list.addAll( list );
    }

    public MaxHeap()
    {
    }

    public int size()
    {
        return list.size();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public List< Integer > getHeap()
    {
        return list;
    }

    private int getParentIndex( int index )
    {
        if ( index == 0 ) return 0;
        return ( index - 1 ) / 2;
    }

    private int getLeftChildIndex( int index )
    {
        return index * 2 + 1;
    }

    private int getRightChildIndex( int index )
    {
        return index * 2 + 2;
    }

    public void add( int val )
    {
        list.add( val );
        siftUp( list.size() - 1 );
    }

    private void siftUp( int index )
    {
        if ( index <= 0 ) return;
        int parentIndex = getParentIndex( index );
        if ( list.get( parentIndex ) < list.get( index ) )
        {
            swap( index, parentIndex );
            siftUp( parentIndex );
        }
    }

    private void swap( int index, int parentIndex )
    {
        if ( index >= 0 && index < list.size() && parentIndex >= 0 && parentIndex < list.size() )
        {
            int temp = list.get( parentIndex );
            list.set( parentIndex, list.get( index ) );
            list.set( index, temp );
        }
    }

    public int getMaximum()
    {
        int maximum = list.get( 0 );
        int last = list.get( list.size() - 1 );
        list.set( 0, last );
        list.remove( list.size() - 1 );
        siftDown( 0 );
        return maximum;
    }

    private void siftDown( int parentIndex )
    {
        if ( parentIndex < 0 || parentIndex >= list.size() ) return;
        int maxChild;
        int maxChildIndex;
        int leftIndex = getLeftChildIndex( parentIndex );
        if ( ( leftIndex < 0 || leftIndex >= list.size() ) )
        {
            return;
        }
        else
        {
            if ( leftIndex + 1 < list.size() )
            {
                maxChild = Math.max( list.get( leftIndex ), list.get( leftIndex + 1 ) );
                maxChildIndex = list.get( leftIndex ) > list.get( leftIndex + 1 ) ? leftIndex : leftIndex + 1;
            }
            else
            {
                maxChild = list.get( leftIndex );
                maxChildIndex = leftIndex;
            }
        }
        if ( list.get( parentIndex ) < maxChild )
        {
            swap( parentIndex, maxChildIndex );
            siftDown( maxChildIndex );
        }
    }

    public int replace( int val )
    {
        int maximum = list.get( 0 );
        list.set( 0, val );
        siftDown( 0 );
        return maximum;
    }

    public void heapify()
    {
        int lastNodeWithChildIndex = ( list.size() - 1 - 1 ) / 2;
        for ( int i = lastNodeWithChildIndex; i >= 0; i-- )
        {
            siftDown( i );
        }
    }

    public void sort()
    {
        int start = 0;
        int end = list.size() - 1;
        while ( start < end )
        {
            if ( list.get( start ) > list.get( end ) )
            {
                swap( start, end );
                siftDownWithCondition( start, ( end - 1 ) / 2 );
            }
            end--;
        }
    }

    private void siftDownWithCondition( int parentIndex, int end )
    {
        if ( parentIndex >= end ) return;
        if ( parentIndex < 0 || parentIndex >= list.size() ) return;
        int maxChild;
        int maxChildIndex;
        int leftIndex = getLeftChildIndex( parentIndex );
        if ( ( leftIndex < 0 || leftIndex >= list.size() ) )
        {
            return;
        }
        else
        {
            if ( leftIndex + 1 < list.size() )
            {
                maxChild = Math.max( list.get( leftIndex ), list.get( leftIndex + 1 ) );
                maxChildIndex = list.get( leftIndex ) > list.get( leftIndex + 1 ) ? leftIndex : leftIndex + 1;
            }
            else
            {
                maxChild = list.get( leftIndex );
                maxChildIndex = leftIndex;
            }
        }
        if ( list.get( parentIndex ) < maxChild )
        {
            swap( parentIndex, maxChildIndex );
            siftDownWithCondition( maxChildIndex, end );
        }
    }
}


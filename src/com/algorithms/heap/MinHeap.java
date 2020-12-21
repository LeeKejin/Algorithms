package com.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap
{
    private List< Integer > list = new ArrayList<>();

    public MinHeap( List< Integer > list )
    {
        this.list.addAll( list );
    }

    public MinHeap()
    {
    }

    public List< Integer > getMinHeap()
    {
        return list;
    }

    public int getSize()
    {
        return list.size();
    }

    public int getLeftChildIndex( int parentIndex )
    {
        return parentIndex * 2 + 1;
    }

    public int getRightChildIndex( int parentIndex )
    {
        return parentIndex * 2 + 2;
    }

    public void add( int val )
    {
        list.add( val );
        siftUp( list.size() - 1 );
    }

    public int getParentIndex( int childIndex )
    {
        return ( childIndex - 1 ) / 2;
    }

    private void siftUp( int childIndex )
    {
        if ( childIndex < 0 ) return;
        int parentIndex = getParentIndex( childIndex );
        if ( list.get( parentIndex ) > list.get( childIndex ) )
        {
            swap( parentIndex, childIndex );
            siftUp( parentIndex );
        }
    }

    private void swap( int parentIndex, int childIndex )
    {
        int temp = list.get( parentIndex );
        list.set( parentIndex, list.get( childIndex ) );
        list.set( childIndex, temp );
    }

    public int minimum()
    {
        int min = list.get( 0 );
        int last = list.get( list.size() - 1 );
        list.set( 0, last );
        list.remove( list.size() - 1 );
        siftDown( 0 );
        return min;
    }

    private void siftDown( int index )
    {
        if ( index >= list.size() ) return;
        int left = getLeftChildIndex( index );
        if ( left >= list.size() ) return;
        if ( left + 1 < list.size() )
        {
            int childIndex = list.get( left ) < list.get( left + 1 ) ? left : left + 1;
            if ( list.get( index ) > list.get( childIndex ) )
            {
                swap( childIndex, index );
                siftDown( childIndex );
            }
        }
        else
        {
            if ( list.get( index ) > list.get( left ) )
            {
                swap( left, index );
                siftDown( left );
            }
        }
    }

    public void sort()
    {
        for ( int i = 0; i < list.size(); i++ )
        {
            swap( list.size() - 1 - i, 0 );
            siftDownWithCondition( 0, list.size() - 1 - i );
        }
    }

    private void siftDownWithCondition( int index, int end )
    {
        //        if ( index > end ) return;
        int left = getLeftChildIndex( index );
        if ( left >= end ) return;
        if ( left + 1 < end )
        {
            int minIndex = list.get( left ) < list.get( left + 1 ) ? left : left + 1;
            if ( list.get( index ) > list.get( minIndex ) )
            {
                swap( minIndex, index );
                siftDownWithCondition( minIndex, end );
            }
            else
            {
                return;
            }
        }
        else
        {
            if ( list.get( index ) > list.get( left ) )
            {
                swap( left, index );
                siftDownWithCondition( left, end );
            }
            else
            {
                return;
            }
        }
    }

    public void heapify()
    {
        int lastParentIndex = getParentIndex( list.size() - 1 );
        for ( int i = lastParentIndex; i >= 0; i-- )
        {
            siftDown( i );
        }
    }
}


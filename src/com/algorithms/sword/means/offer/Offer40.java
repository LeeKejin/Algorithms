package com.algorithms.sword.means.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Offer40
{
    static Random random = new Random();

    public int[] getLeastNumbers( int[] arr, int k )
    {
        if ( k == 0 ) return new int[] {};
        return quickSort( arr, 0, arr.length, k );
    }

    public int[] getLeastNumbersPriorityQueue( int[] arr, int k )
    {
        if ( k == 0 || arr.length == 0 ) return new int[] {};
        //        Collections.reverseOrder()
        PriorityQueue< Integer > queue = new PriorityQueue<>( k, ( a, b ) -> a >= b ? -1 : 1 );
        for ( int val : arr )
        {
            if ( queue.size() < k )
            {
                queue.add( val );
            }
            else
            {
                if ( queue.peek() > val )
                {
                    queue.poll();
                    queue.add( val );
                }
            }
        }
        int[] results = new int[ k ];
        for ( int i = 0; i < k; i++ )
        {
            results[ i ] = queue.poll();
        }
        return results;
    }

    private int[] quickSort( int[] arr, int start, int end, int k )
    {
        if ( start >= end ) return arr;
        List< Integer > list = partition( arr, start, end );
        int p = list.get( 0 );
        swap( arr, p, start );
        if ( p == ( k - 1 ) )
        {
            int[] results = new int[ k ];
            System.arraycopy( arr, 0, results, 0, k );
            return results;
        }
        else if ( p < ( k - 1 ) )
        {
            return quickSort( arr, p + 1, end, k );
        }
        else
        {
            return quickSort( arr, start, list.get( 1 ), k );
        }
    }

    private List< Integer > partition( int[] arr, int start, int end )
    {
        int p = start + random.nextInt( end - start );
        swap( arr, p, start );
        int pivot = arr[ start ];
        start++;
        end--;
        int i = start;
        while ( i <= end )
        {
            if ( arr[ i ] == pivot )
            {
                i++;
            }
            else if ( arr[ i ] > pivot )
            {
                swap( arr, i, end );
                end--;
            }
            else
            {
                swap( arr, i, start );
                start++;
                i++;
            }
        }
        List< Integer > list = new ArrayList<>();
        list.add( start - 1 );
        list.add( end );
        return list;
    }

    private void swap( int[] arr, int j, int i )
    {
        int temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }

    public static void main( String[] args )
    {
        Offer40 offer40 = new Offer40();
        int[] arr = new int[] { 3, 2, 1 };
        int[] res = offer40.getLeastNumbers( arr, 2 );
        System.out.println( res );
    }
}

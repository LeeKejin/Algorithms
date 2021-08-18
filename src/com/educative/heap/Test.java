package com.educative.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Test
{
    public static int findMaximumCapital( int[] capital, int[] profits, int numberOfProjects, int initialCapital )
    {
        PriorityQueue< Integer > minHeap = new PriorityQueue<>();
        PriorityQueue< Integer > maxHeap = new PriorityQueue<>( Collections.reverseOrder() );
        for ( int i = 0; i < capital.length; i++ )
        {
            minHeap.add( i );
        }

        for ( int i = 0; i < numberOfProjects; i++ )
        {
            while ( !minHeap.isEmpty() && initialCapital >= capital[ minHeap.peek() ] )
            {
                maxHeap.add( profits[ minHeap.peek() ] );
                minHeap.poll();
            }
            if ( maxProfitHeap.isEmpty() )
                break;
            initialCapital += maxHeap.poll();
        }
        return initialCapital;
    }

    public static void main( String[] args )
    {
        int result = findMaximumCapital( new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1 );
        System.out.println( "Maximum capital: " + result );
        result = findMaximumCapital( new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0 );
        System.out.println( "Maximum capital: " + result );
    }
}

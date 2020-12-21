package com.algorithms.heap;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test
{
    public boolean canVisitAllRooms( List< List< Integer > > rooms )
    {
        boolean[] visited = new boolean[ rooms.size() ];
        visited[ 0 ] = true;
        Queue< Integer > queue = new LinkedList<>();
        for ( int key : rooms.get( 0 ) )
        {
            queue.add( key );
        }
        while ( !queue.isEmpty() )
        {
            int key = queue.poll();
            visited[ key ] = true;
            List< Integer > keys = rooms.get( key );
            for ( int k : keys )
            {
                if ( !visited[ k ] )
                {
                    queue.add( k );
                }
            }
        }
        for ( boolean visit : visited )
        {
            if ( !visit ) return false;
        }
        return true;
    }

    public static void main( String[] args )
    {
        String[] tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        int[] arr = new int[] { 41, 6, 16, 24, 31, 40, 44, 22, 15, 9, 29, 3, 31, 10, 50, 44, 39, 47, 45, 47 };

        Test t = new Test();
        //        char[][] grid =
        //            { { '1', '1', '1', '1', '0' },
        //                { '1', '1', '0', '1', '0' },
        //                { '1', '1', '0', '0', '0' },
        //                { '0', '0', '0', '0', '0' } };
        int[][] grid =
            { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };

        t.findMinHeightTrees( 6, grid );

    }

}



package com.amazon.interview;

import java.util.LinkedList;
import java.util.Queue;

public class Leet210
{
    public int[] findOrder( int numCourses, int[][] prerequisites )
    {
        if ( numCourses == 0 ) return new int[ 0 ];
        int[] inDegree = new int[ numCourses ];
        int[] res = new int[ numCourses ];
        for ( int i = 0; i < prerequisites.length; i++ )
        {
            inDegree[ prerequisites[ i ][ 0 ] ]++;
        }

        Queue< Integer > queue = new LinkedList<>();
        for ( int i = 0; i < inDegree.length; i++ )
        {
            if ( inDegree[ i ] == 0 ) queue.add( i );
        }
        int count = 0;
        while ( !queue.isEmpty() )
        {
            int cur = queue.poll();
            res[ count ] = cur;
            count++;
            for ( int i = 0; i < prerequisites.length; i++ )
            {
                if ( prerequisites[ i ][ 1 ] == cur )
                {
                    inDegree[ prerequisites[ i ][ 0 ] ]--;
                    if ( inDegree[ prerequisites[ i ][ 0 ] ] == 0 )
                    {
                        queue.add( prerequisites[ i ][ 0 ] );
                    }

                }
            }
            if ( count == res.length ) return res;
        }
        return new int[ 0 ];
    }
}
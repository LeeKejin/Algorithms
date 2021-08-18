package com.amazon.interview.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet210
{
    public int[] findOrder( int numCourses, int[][] prerequisites )
    {
        int[] degree = new int[ numCourses ];
        int count = 0;
        int[] res = new int[ numCourses ];
        List< List< Integer > > list = new ArrayList<>();
        Queue< Integer > queue = new LinkedList<>();
        for ( int i = 0; i < numCourses; i++ )
        {
            list.add( new ArrayList<>() );
        }
        for ( int[] p : prerequisites )
        {
            degree[ p[ 0 ] ]++;
            list.get( p[ 1 ] ).add( p[ 0 ] );
        }
        for ( int i = 0; i < numCourses; i++ )
        {
            if ( degree[ i ] == 0 ) queue.add( i );
        }
        while ( !queue.isEmpty() )
        {
            int prev = queue.poll();
            res[ count ] = prev;
            count++;
            for ( int d : list.get( prev ) )
            {
                degree[ d ]--;
                if ( degree[ d ] == 0 )
                {
                    queue.add( d );
                }
            }
        }
        if ( count != numCourses ) return new int[] {};
        return res;
    }
}
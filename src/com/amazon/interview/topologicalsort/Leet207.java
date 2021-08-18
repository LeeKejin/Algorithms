package com.amazon.interview.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet207
{
    public boolean canFinish( int numCourses, int[][] prerequisites )
    {
        int[] degree = new int[ numCourses ];
        List< List< Integer > > list = new ArrayList<>();
        for ( int i = 0; i < numCourses; i++ )
        {
            list.add( new ArrayList<>() );
        }
        for ( int[] p : prerequisites )
        {
            degree[ p[ 0 ] ]++;
            list.get( p[ 1 ] ).add( p[ 0 ] );
        }
        Queue< Integer > queue = new LinkedList<>();

        for ( int i = 0; i < degree.length; i++ )
        {
            if ( degree[ i ] == 0 ) queue.add( i );
        }
        int count = 0;
        while ( !queue.isEmpty() )
        {
            int prev = queue.poll();
            count++;
            for ( int dependency : list.get( prev ) )
            {
                degree[ dependency ]--;
                if ( degree[ dependency ] == 0 )
                {
                    queue.add( dependency );
                }
            }
        }
        return count == numCourses;
    }
}

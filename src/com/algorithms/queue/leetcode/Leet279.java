package com.algorithms.queue.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leet279
{
    Set< Integer > squares = new HashSet<>();
    Set< Integer > visited = new HashSet<>();

    public int numSquares( int n )
    {
        for ( int i = 1; i < n; i++ )
        {
            if ( i * i <= n ) squares.add( i * i );
        }
        int count = 0;
        Queue< Integer > queue = new LinkedList<>();
        queue.add( n );
        visited.add( n );
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            for ( int i = 0; i < size; i++ )
            {
                int cur = queue.poll();
                if ( cur == 0 ) return count;
                bfs( cur, queue );
            }
            count++;
        }
        return count;
    }

    private void bfs( int cur, Queue< Integer > queue )
    {
        for ( int val : squares )
        {
            int newValue = cur - val;
            if ( newValue >= 0 && !visited.contains( newValue ) )
            {
                queue.add( newValue );
                visited.add( newValue );
            }
        }
    }
}

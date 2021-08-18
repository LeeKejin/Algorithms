package com.amazon.interview.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Leet1197
{
    int[][] dirs =
        new int[][] { { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 }, { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 } };

    public int minKnightMoves( int x, int y )
    {
        Queue< Node > queue = new LinkedList<>();
        boolean visited[][] = new boolean[ 666 ][ 666 ];
        int startDist = getDistance( 0, 0, x, y );
        queue.add( new Node( 0, 0, 0 ) );
        visited[ 333 ][ 333 ] = true;
        while ( !queue.isEmpty() )
        {
            Node node = queue.poll();
            int curX = node.x;
            int curY = node.y;
            int dist = node.dist;
            if ( curX == x && curY == y ) return dist;
            int leftDist = getDistance( curX, curY, x, y );
            for ( int[] dir : dirs )
            {
                int newX = dir[ 0 ] + curX;
                int newY = dir[ 1 ] + curY;
                int newDist = dist + 1;
                if ( visited[ newX + 333 ][ newY + 333 ] ) continue;
                if ( leftDist > getDistance( newX, newY, x, y ) || startDist < 4 )
                {
                    queue.add( new Node( newX, newY, newDist ) );
                    visited[ newX + 333 ][ newY + 333 ] = true;
                }
            }
        }
        return -1;

    }

    private int getDistance( int x, int y, int targetX, int targetY )
    {
        return Math.abs( x - targetX ) + Math.abs( y - targetY );
    }

    class Node
    {
        int x;
        int y;
        int dist;

        Node( int x, int y, int dist )
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

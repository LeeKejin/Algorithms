package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class Leet323
{
    public int countComponentsDFS( int n, int[][] edges )
    {
        boolean visit[] = new boolean[ n ];
        List< List< Integer > > edgeList = new ArrayList<>();
        int count = 0;
        for ( int i = 0; i < n; i++ )
        {
            edgeList.add( new ArrayList<>() );
        }

        for ( int[] edge : edges )
        {
            edgeList.get( edge[ 0 ] ).add( edge[ 1 ] );
            edgeList.get( edge[ 1 ] ).add( edge[ 0 ] );
        }
        for ( int i = 0; i < n; i++ )
        {
            if ( !visit[ i ] )
            {
                count++;
                dfs( i, edgeList, visit );
            }
        }
        return count;
    }

    private void dfs( int i, List< List< Integer > > edgeList, boolean[] visit )
    {
        visit[ i ] = true;
        for ( int point : edgeList.get( i ) )
        {
            if ( !visit[ point ] )
            {
                visit[ point ] = true;
                dfs( point, edgeList, visit );
            }
        }
    }

    class UnionClass
    {
        int[] parents;

        public UnionClass( int n )
        {
            parents = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parents[ i ] = i;
            }
        }

        public void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parents[ rootX ] = rootY;
            }
        }

        private int find( int x )
        {
            if ( parents[ x ] != x )
            {
                parents[ x ] = find( parents[ x ] );
            }
            return parents[ x ];
        }
    }

    public int countComponents( int n, int[][] edges )
    {
        int count = 0;
        UnionClass unionClass = new UnionClass( n );
        for ( int[] edge : edges )
        {
            unionClass.merge( edge[ 0 ], edge[ 1 ] );
        }
        for ( int i = 0; i < n; i++ )
        {
            if ( i == unionClass.parents[ i ] )
            {
                count++;
            }
        }
        return count;
    }

}

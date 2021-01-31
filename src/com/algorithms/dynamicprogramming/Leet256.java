package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Leet256
{
    public int minCostDP( int[][] costs )
    {
        if ( costs.length == 0 ) return 0;
        int[][] dp = new int[ costs.length ][ 3 ];
        for ( int i = 0; i < 3; i++ )
        {
            dp[ costs.length - 1 ][ i ] = costs[ costs.length - 1 ][ i ];
        }
        for ( int i = costs.length - 2; i >= 0; i-- )
        {
            dp[ i ][ 0 ] = costs[ i ][ 0 ] + Math.min( dp[ i + 1 ][ 1 ], dp[ i + 1 ][ 2 ] );
            dp[ i ][ 1 ] = costs[ i ][ 1 ] + Math.min( dp[ i + 1 ][ 0 ], dp[ i + 1 ][ 2 ] );
            dp[ i ][ 2 ] = costs[ i ][ 2 ] + Math.min( dp[ i + 1 ][ 0 ], dp[ i + 1 ][ 1 ] );
        }
        int res = Integer.MAX_VALUE;
        for ( int i = 0; i < 3; i++ )
        {
            res = Math.min( dp[ 0 ][ i ], res );
        }
        return res;
    }

    public int minCost2( int[][] costs )
    {
        if ( costs.length == 0 ) return 0;
        return Math.min( Math.min( paint( costs, 0, 0 ), paint( costs, 0, 1 ) ), paint( costs, 0, 2 ) );
    }

    private int paint( int[][] costs, int house, int color )
    {
        int price = costs[ house ][ color ];
        if ( house == costs.length - 1 ) return price;
        if ( color == 0 )
        {
            price += Math.min( paint( costs, house + 1, 1 ), paint( costs, house + 1, 2 ) );
            return price;
        }
        if ( color == 1 )
        {
            price += Math.min( paint( costs, house + 1, 0 ), paint( costs, house + 1, 2 ) );
            return price;
        }
        if ( color == 2 )
        {
            price += Math.min( paint( costs, house + 1, 0 ), paint( costs, house + 1, 1 ) );
            return price;
        }
        return Integer.MAX_VALUE;
    }

    public int minCost1( int[][] costs )
    {
        if ( costs.length == 0 ) return 0;
        List< Integer > list = new ArrayList<>();
        for ( int i = 0; i < costs[ 0 ].length; i++ )
        {
            list.addAll( dfs( costs, 0, i ) );
        }
        int max = Integer.MAX_VALUE;
        for ( int v : list )
        {
            max = Math.min( v, max );
        }
        return max;
    }

    private List< Integer > dfs( int[][] costs, int house, int i )
    {
        List< Integer > list = new ArrayList<>();
        if ( house == costs.length - 1 )
        {
            for ( int j = 0; j < 3; j++ )
            {
                if ( j == i ) continue;
                list.add( costs[ house ][ j ] );
            }
            return list;
        }
        for ( int j = 0; j < 3; j++ )
        {
            if ( j == i ) continue;

            List< Integer > vals = dfs( costs, house + 1, j );
            for ( int val : vals )
            {
                int v = costs[ house ][ j ] + val;
                list.add( v );
            }

        }
        return list;
    }

}

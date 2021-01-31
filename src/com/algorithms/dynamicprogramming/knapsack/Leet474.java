package com.algorithms.dynamicprogramming.knapsack;

public class Leet474
{
    public int findMaxForm( String[] strs, int m, int n )
    {
        if ( strs.length == 0 ) return 0;

        int[][][] dp = new int[ strs.length ][ m + 1 ][ n + 1 ];
        int[] cont = calculateZeroAndOne( strs[ 0 ] );

        //Initialize
        for ( int i = 0; i <= m; i++ )
        {
            for ( int j = 0; j <= n; j++ )
            {
                if ( i - cont[ 0 ] >= 0 && j - cont[ 1 ] >= 0 ) dp[ 0 ][ i ][ j ] = 1;
            }
        }

        for ( int i = 1; i < strs.length; i++ )
        {
            int[] contInner = calculateZeroAndOne( strs[ i ] );
            for ( int j = 0; j <= m; j++ )
            {
                for ( int k = 0; k <= n; k++ )
                {
                    dp[ i ][ j ][ k ] = dp[ i - 1 ][ j ][ k ];
                    if ( j >= contInner[ 0 ] && k >= contInner[ 1 ] )
                    {
                        dp[ i ][ j ][ k ] = Math.max( dp[ i - 1 ][ j ][ k ],
                            dp[ i - 1 ][ j - contInner[ 0 ] ][ k - contInner[ 1 ] ] + 1 );
                    }

                }
            }
        }
        return dp[ strs.length - 1 ][ m ][ n ];
    }

    private int[] calculateZeroAndOne( String str )
    {

        int zero = 0;
        int one = 0;

        for ( int i = 0; i < str.length(); i++ )
        {
            if ( str.charAt( i ) == '0' )
            {
                zero++;
            }
            else
            {
                one++;
            }
        }

        return new int[] { zero, one };
    }

    public int findMaxFormSpaceOptimize( String[] strs, int m, int n )
    {
        if ( strs.length == 0 ) return 0;

        int[][] dp = new int[ m + 1 ][ n + 1 ];
        int[] cont = calculateZeroAndOne( strs[ 0 ] );

        //Initialize
        for ( int i = 0; i <= m; i++ )
        {
            for ( int j = 0; j <= n; j++ )
            {
                if ( i - cont[ 0 ] >= 0 && j - cont[ 1 ] >= 0 ) dp[ i ][ j ] = 1;
            }
        }

        for ( int i = 1; i < strs.length; i++ )
        {
            int[] contInner = calculateZeroAndOne( strs[ i ] );
            for ( int j = m; j >= 0; j-- )
            {
                for ( int k = n; k >= 0; k-- )
                {
                    if ( j >= contInner[ 0 ] && k >= contInner[ 1 ] )
                    {
                        dp[ j ][ k ] = Math.max( dp[ j ][ k ],
                            dp[ j - contInner[ 0 ] ][ k - contInner[ 1 ] ] + 1 );
                    }

                }
            }
        }
        return dp[ m ][ n ];
    }
}

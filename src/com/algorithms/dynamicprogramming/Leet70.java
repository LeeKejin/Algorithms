package com.algorithms.dynamicprogramming;

public class Leet70
{
    static int count = 0;
    static int[] list = new int[ 5000 ];

    public static int climbStairsDynamicProgramming( int n )
    {
        int[] arr = new int[ n + 1 ];

        arr[ 0 ] = 1;
        arr[ 1 ] = 1;

        for ( int i = 2; i < n + 1; i++ )
        {
            arr[ i ] = arr[ i - 1 ] + arr[ i - 2 ];
        }
        return arr[ n ];
    }

    public static int climbStairs( int n )
    {
        if ( n < 0 ) return 0;
        for ( int i = 0; i < 5000; i++ )
        {
            list[ i ] = -1;
        }
        return calculate( n );
    }

    private static int calculate( int n )
    {
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;
        int k = 0;
        if ( list[ n - 1 ] != -1 )
        {
            k = list[ n - 1 ];
        }
        else
        {
            k = calculate( n - 1 );
            list[ n - 1 ] = k;

        }
        int m = 0;
        if ( list[ n - 2 ] != -1 )
        {
            m = list[ n - 2 ];
        }
        else
        {
            m = calculate( n - 2 );
            list[ n - 2 ] = m;

        }
        return m + k;
    }

    private static int calculate1( int n )
    {
        if ( n == 0 || n == 1 ) return 1;
        if ( list[ n ] == -1 )
        {
            list[ n ] = calculate1( n - 1 ) + calculate1( n - 2 );
        }
        return list[ n ];
    }

    public static void main( String[] args )
    {
        System.out.print( climbStairs( 44 ) );
    }

}

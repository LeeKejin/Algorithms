package com.amazon.interview.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Leet1710
{
    public int maximumUnits( int[][] boxTypes, int truckSize )
    {
        Arrays.sort( boxTypes, new Comparator< int[] >()
        {
            @Override
            public int compare( int[] o1, int[] o2 )
            {
                if ( o1[ 1 ] == o2[ 1 ] ) return o1[ 0 ] - o2[ 0 ];
                return o2[ 1 ] - o1[ 1 ];
            }
        } );
        int i;
        for ( i = 0; i < boxTypes.length; i++ )
        {
            int[] box = boxTypes[ i ];
            if ( truckSize >= box[ 0 ] )
            {
                truckSize -= box[ 0 ];
            }
            else
            {
                break;
            }
        }
        int res = 0;
        if ( i < boxTypes.length )
            res += boxTypes[ i ][ 1 ] * truckSize;
        for ( int j = 0; j < i; j++ )
        {
            res += boxTypes[ j ][ 0 ] * boxTypes[ j ][ 1 ];
        }
        return res;
    }
}

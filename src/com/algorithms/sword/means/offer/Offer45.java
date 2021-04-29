package com.algorithms.sword.means.offer;

public class Offer45
{
    public String minNumber( int[] nums )
    {
        String[] strs = new String[ nums.length ];
        for ( int i = 0; i < nums.length; i++ )
        {
            strs[ i ] = String.valueOf( nums[ i ] );
        }

        quickSort( strs, 0, strs.length - 1 );

        StringBuilder sb = new StringBuilder();
        for ( String str : strs )
        {
            sb.append( str );
        }
        return sb.toString();
    }

    void quickSort( String[] strs, int l, int r )
    {
        if ( l > r ) return;
        int i = l, j = r;
        while ( i < j )
        {
            while ( ( strs[ j ] + strs[ l ] ).compareTo( strs[ l ] + strs[ j ] ) >= 0 && i < j )
            {
                j--;
            }
            while ( ( strs[ i ] + strs[ l ] ).compareTo( strs[ l ] + strs[ i ] ) <= 0 && i < j )
            {
                i++;
            }
            swap( strs, i, j );
        }

        swap( strs, l, i );
        quickSort( strs, l, i - 1 );
        quickSort( strs, i + 1, r );
    }

    private void swap( String[] strs, int i, int j )
    {
        String tmp = strs[ i ];
        strs[ i ] = strs[ j ];
        strs[ j ] = tmp;

    }
}

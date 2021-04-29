package com.algorithms.sword.means.offer;

public class Offer46_DP
{
    public int translateNumDP( int num )
    {
        String str = String.valueOf( num );
        int dp[] = new int[ str.length() + 1 ];
        dp[ 0 ] = 1;
        dp[ 1 ] = 1;
        for ( int i = 2; i <= str.length(); i++ )
        {
            if ( str.charAt( i - 2 ) != '0' && Integer.parseInt( str.substring( i - 2, i ) ) <= 25 )
            {
                dp[ i ] = dp[ i - 1 ] + dp[ i - 2 ];
            }
            else
            {
                dp[ i ] = dp[ i - 1 ];
            }
        }
        return dp[ str.length() ];
    }

    public int translateNum( int num )
    {
        String str = String.valueOf( num );
        return find( str );

    }

    private int find( String str )
    {
        if ( str.length() == 0 )
        {
            return 1;
        }

        if ( str.length() == 1 || Integer.parseInt( str.substring( 0, 2 ) ) > 25 || str.charAt( 0 ) == '0' )
        {
            return find( str.substring( 1 ) );
        }
        return find( str.substring( 1 ) ) + find( str.substring( 2 ) );
    }
}

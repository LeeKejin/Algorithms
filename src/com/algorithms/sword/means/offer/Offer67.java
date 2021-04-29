package com.algorithms.sword.means.offer;

public class Offer67
{
    public int strToInt( String str )
    {
        int i;
        for ( i = 0; i < str.length(); i++ )
        {
            if ( str.charAt( i ) != ' ' ) break;
        }

        str = str.substring( i );
        int sign = 1;
        if ( str.startsWith( "-" ) )
        {
            sign = -1;
            str = str.substring( 1 );
        }
        else if ( str.startsWith( "+" ) )
        {
            str = str.substring( 1 );
        }
        long res = 0;

        for ( int j = 0; j < str.length(); j++ )
        {
            if ( str.charAt( j ) >= '0' && str.charAt( j ) <= '9' )
            {
                res = res * 10 + Integer.parseInt( String.valueOf( str.charAt( j ) ) );
                if ( res > Integer.MAX_VALUE )
                {
                    if ( sign == -1 ) return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
            }
            else
            {
                break;
            }
        }
        if ( sign == -1 )
        {
            return 0 - ( int ) res;
        }
        return ( int ) res;
    }
}

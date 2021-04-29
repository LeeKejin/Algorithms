package com.amazon.interview;

public class Leet8
{
    public int myAtoi( String s )
    {
        if ( s.length() == 0 ) return 0;
        int space = 0;
        for ( char ch : s.toCharArray() )
        {
            if ( ch == ' ' )
            {
                space++;
            }
            else
            {
                break;
            }
        }

        String str = s.substring( space );
        if ( str.length() == 0 ) return 0;
        int sign = 1;
        if ( str.toCharArray()[ 0 ] == '-' )
        {
            sign = -1;
            str = str.substring( 1 );
        }
        else if ( str.toCharArray()[ 0 ] == '+' )
        {
            str = str.substring( 1 );
        }
        long val = 0;
        for ( char ch : str.toCharArray() )
        {
            if ( Character.isDigit( ch ) )
            {
                val = val * 10 + Long.parseLong( String.valueOf( ch ) );
                if ( val > Integer.MAX_VALUE )
                {
                    if ( sign == 1 )
                    {
                        return Integer.MAX_VALUE;
                    }
                    return Integer.MIN_VALUE;
                }
            }
            else
            {
                break;
            }
        }
        if ( sign == 1 ) return ( int ) val;
        return -( int ) val;
    }
}

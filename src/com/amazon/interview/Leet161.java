package com.amazon.interview;

public class Leet161
{
    public boolean isOneEditDistance( String s, String t )
    {
        if ( s.equals( t ) ) return false;

        if ( s.length() == t.length() )
        {
            int val = 0;
            for ( int i = 0; i < s.length(); i++ )
            {
                if ( s.charAt( i ) != t.charAt( i ) ) val++;
            }
            return val == 1;
        }

        if ( s.length() < t.length() )
        {
            return compare( s, t );
        }
        return compare( t, s );
    }

    private boolean compare( String s, String t )
    {
        if ( t.length() - s.length() != 1 ) return false;
        for ( int i = 0; i < t.length(); i++ )
        {
            String prev = t.substring( 0, i );
            String after = t.substring( i + 1 );
            String newStr = prev + after;
            if ( newStr.equals( s ) ) return true;
        }
        return false;
    }
}

package com.amazon.interview;

public class Leet796
{
    public boolean rotateString( String A, String B )
    {
        if ( A.equals( B ) ) return true;
        for ( int i = 1; i < A.length(); i++ )
        {
            String prev = A.substring( 0, i );
            String after = A.substring( i );
            if ( ( after + prev ).equals( B ) ) return true;
        }
        return false;
    }
}


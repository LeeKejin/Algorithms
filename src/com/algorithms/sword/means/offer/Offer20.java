package com.algorithms.sword.means.offer;

public class Offer20
{
    int index = 0;

    public boolean isNumber( String s )
    {
        if ( s == null || s.length() == 0 ) return false;
        while ( index < s.length() && s.charAt( index ) == ' ' )
        {
            index++;
        }
        boolean numeric = scanInteger( s );
        if ( index < s.length() && s.charAt( index ) == '.' )
        {
            index++;
            numeric = scanUnsignedInteger( s ) || numeric;
        }
        if ( index < s.length() && ( s.charAt( index ) == 'e' || s.charAt( index ) == 'E' ) )
        {
            index++;
            numeric = scanInteger( s ) && numeric;
        }
        while ( index < s.length() && s.charAt( index ) == ' ' )
        {
            index++;
        }
        return index == s.length() && numeric;
    }

    private boolean scanInteger( String s )
    {
        if ( index >= s.length() ) return false;
        if ( s.charAt( index ) == '-' || s.charAt( index ) == '+' ) index++;
        return scanUnsignedInteger( s );
    }

    private boolean scanUnsignedInteger( String s )
    {
        if ( index >= s.length() ) return false;
        int temp = index;
        while ( index < s.length() && ( s.charAt( index ) >= '0' && s.charAt( index ) <= '9' ) )
        {
            index++;
        }
        return index > temp;
    }
}

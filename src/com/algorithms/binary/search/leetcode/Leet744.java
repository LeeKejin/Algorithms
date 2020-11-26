package com.algorithms.binary.search.leetcode;

public class Leet744
{
    public char nextGreatestLetter( char[] letters, char target )
    {
        return nextGreatestLetter( letters, target, 0, letters.length - 1 );
    }

    private char nextGreatestLetter( char[] letters, char target, int l, int r )
    {
        if ( l > r ) return letters[ 0 ];
        if ( l == r )
        {
            if ( letters[ l ] <= target ) return letters[ 0 ];
            return letters[ l ];
        }
        int mid = l + ( r - l ) / 2;
        if ( target >= letters[ mid ] )
        {
            return nextGreatestLetter( letters, target, mid + 1, r );
        }
        return nextGreatestLetter( letters, target, l, mid );
    }
}

package com.algorithms.array.leetcode;

import static java.lang.Character.compare;
import static java.lang.Character.toLowerCase;

public class Leet125
{
    public static boolean isPalindrome( String s )
    {
        if ( s.equals( null ) || s.length() == 1 || s.equals( "" ) ) return true;
        int first = 0;
        int last = s.length() - 1;
        while ( first < last )
        {
            char firstChar = s.charAt( first );
            char lastChar = s.charAt( last );
            if ( !Character.isLetterOrDigit( firstChar ) )
            {
                first++;
                continue;
            }
            if ( !Character.isLetterOrDigit( lastChar ) )
            {
                last--;
                continue;
            }
            if ( first < last && compare( toLowerCase( firstChar ), toLowerCase( lastChar ) ) != 0 )
            {
                return false;
            }
            if ( first == last ) return true;
            first++;
            last--;
        }
        return true;
    }

    public static void main( String[] args )
    {
        //        isPalindrome( "A man, a plan, a canal: Panama" );
        isPalindrome( ".," );

    }
}

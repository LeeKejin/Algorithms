package com.algorithms.array.leetcode;

public class Leet345
{
    public String reverseVowels( String s )
    {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        if ( left <= right )
        {
            if ( isVowel( s.charAt( left ) ) && isVowel( s.charAt( right ) ) )
            {
                char temp = chars[ left ];
                chars[ left ] = chars[ right ];
                chars[ right ] = temp;
                left++;
                right--;
            }
            else if ( isVowel( s.charAt( left ) ) && !isVowel( s.charAt( right ) ) )
            {
                right--;
            }
            else if ( !isVowel( s.charAt( left ) ) && isVowel( s.charAt( right ) ) )
            {
                left++;
            }
            else
            {
                left++;
                right--;
            }
        }
        return String.valueOf( chars );
    }

    private boolean isVowel( char c )
    {
        if ( c == 'a' ) return true;
        if ( c == 'e' ) return true;
        if ( c == 'u' ) return true;
        if ( c == 'o' ) return true;
        if ( c == 'i' ) return true;
        if ( c == 'A' ) return true;
        if ( c == 'E' ) return true;
        if ( c == 'U' ) return true;
        if ( c == 'O' ) return true;
        if ( c == 'I' ) return true;

        return false;
    }
}

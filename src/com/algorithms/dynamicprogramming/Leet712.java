package com.algorithms.dynamicprogramming;

public class Leet712
{
    public int minimumDeleteSum( String s1, String s2 )
    {
        if ( s1.length() > s2.length() )
        {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        String dp[][] = new String[ s1.length() + 1 ][ s2.length() + 1 ];
        for ( int i = 0; i <= s1.length(); i++ )
        {
            for ( int j = 0; j <= s2.length(); j++ )
            {
                dp[ i ][ j ] = "";
            }
        }
        for ( int i = 1; i <= s1.length(); i++ )
        {
            for ( int j = 1; j <= s2.length(); j++ )
            {
                char ch = s1.charAt( i - 1 );
                if ( ch == s2.charAt( j - 1 ) )
                {
                    dp[ i ][ j ] = dp[ i - 1 ][ j - 1 ] + ch;
                }
                else
                {
                    if ( dp[ i - 1 ][ j ].equals( "" ) )
                    {
                        dp[ i ][ j ] = dp[ i ][ j - 1 ];
                    }
                    else if ( dp[ i ][ j - 1 ].equals( "" ) )
                    {
                        dp[ i ][ j ] = dp[ i - 1 ][ j ];
                    }
                    else
                    {
                        int up = calculate( dp[ i - 1 ][ j ] );
                        int left = calculate( dp[ i ][ j - 1 ] );
                        if ( up > left )
                        {
                            dp[ i ][ j ] = dp[ i - 1 ][ j ];
                        }
                        else
                        {
                            dp[ i ][ j ] = dp[ i ][ j - 1 ];
                        }
                    }

                }
            }
        }
        int n = calculate( dp[ s1.length() ][ s2.length() ] );
        int s1Sum = calculate( s1 );
        int s2Sum = calculate( s2 );
        return s1Sum + s2Sum - 2 * n;
    }

    private int calculate( String s )
    {
        int sum = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            sum += s.charAt( i );
        }
        return sum;
    }
}

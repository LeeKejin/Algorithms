package com.algorithms.array.slidewindow;

public class Leet727
{
    public String minWindow( String S, String T )
    {
        int length = S.length() + 1;
        int i = 0;
        int j = 0;

        String res = "";
        while ( i < S.length() )
        {
            if ( S.charAt( i ) == T.charAt( j ) )
            {
                j++;
            }
            i++;

            if ( j == T.length() )
            {
                int rights = i - 1;
                int rightt = j - 1;

                while ( rightt >= 0 )
                {
                    if ( S.charAt( rights ) == T.charAt( rightt ) )
                    {
                        rightt--;
                    }
                    rights--;
                }
                if ( length > i - rights - 1 )
                {
                    length = i - rights - 1;
                    res = S.substring( rights + 1, i );
                }
                j = 0;
                i = rights + 2;
            }
        }
        return res;
    }
}

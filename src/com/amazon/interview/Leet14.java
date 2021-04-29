package com.amazon.interview;

import java.util.Arrays;

public class Leet14
{
    public String longestCommonPrefix1( String[] strs )
    {
        if ( strs.length == 0 ) return "";
        if ( strs.length == 1 ) return strs[ 0 ];
        Arrays.sort( strs );
        String start = strs[ 0 ];
        String end = strs[ strs.length - 1 ];
        int size = start.length() < end.length() ? start.length() : end.length();
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < size; i++ )
        {
            if ( start.charAt( i ) == end.charAt( i ) )
            {
                sb.append( start.charAt( i ) );
            }
            else
            {
                break;
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix( String[] strs )
    {
        if ( strs.length == 0 ) return "";
        if ( strs.length == 1 ) return strs[ 0 ];

        int length = Integer.MAX_VALUE;
        String s = "";
        for ( String str : strs )
        {
            if ( str.length() < length )
            {
                s = str;
                length = s.length();
            }
        }
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < s.length(); i++ )
        {
            char ch = s.charAt( i );
            for ( int j = 0; j < strs.length; j++ )
            {
                if ( strs[ j ].charAt( i ) != ch ) return sb.toString();
            }

            sb.append( ch );

        }
        return sb.toString();
    }
}

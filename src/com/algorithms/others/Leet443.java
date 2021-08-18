package com.algorithms.others;

public class Leet443
{
    public int compress( char[] chars )
    {
        int anchor = 0;
        int read = 0;
        int write = 0;

        for ( read = 0; read < chars.length; read++ )
        {
            if ( read + 1 == chars.length || chars[ read + 1 ] != chars[ read ] )
            {
                chars[ write ] = chars[ anchor ];
                write++;
                if ( read > anchor )
                {
                    int n = read - anchor + 1;
                    String string = String.valueOf( n );
                    for ( char ch : string.toCharArray() )
                    {
                        chars[ write ] = ch;
                        write++;
                    }

                }

                anchor = read + 1;
            }
        }
        return write;
    }
}

package com.amazon.interview;

import java.util.Stack;

public class Leet394
{
    public String decodeString( String s )
    {
        StringBuilder sb = new StringBuilder();
        Stack< Integer > times = new Stack<>();
        Stack< String > stack = new Stack<>();
        int num = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            char ch = s.charAt( i );
            if ( Character.isDigit( ch ) )
            {
                num = num * 10 + ( ch - '0' );
            }
            else if ( ch == '[' )
            {
                times.push( num );
                num = 0;
                stack.push( sb.toString() );
                sb = new StringBuilder();
            }
            else if ( ch == ']' )
            {
                int n = times.pop();
                StringBuilder sub = new StringBuilder();
                for ( int i1 = 0; i1 < n; i1++ )
                {
                    sub.append( sb );
                }
                sb = new StringBuilder( stack.pop() + sub.toString() );
            }
            else
            {
                sb.append( ch );
            }

        }
        return sb.toString();
    }
}

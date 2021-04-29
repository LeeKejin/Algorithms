package com.amazon.interview;

import java.util.Stack;

public class Leet227
{
    public int calculate( String s )
    {
        if ( s == null ) return 0;
        s = s.replaceAll( " ", "" );
        Stack< Integer > stack = new Stack<>();
        char prevSign = '+';

        int num = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            char ch = s.charAt( i );
            if ( Character.isDigit( ch ) )
            {
                num = num * 10 + ( ch - '0' );

            }
            if ( !Character.isDigit( ch ) || s.length() == i + 1 )
            {
                operate( stack, prevSign, num );
                num = 0;
                prevSign = ch;
            }
        }
        int res = 0;
        while ( !stack.isEmpty() )
        {
            res += stack.pop();
        }
        return res;

    }

    private void operate( Stack< Integer > stack, char prevSign, int num )
    {
        if ( prevSign == '+' )
        {
            stack.push( num );
        }
        else if ( prevSign == '-' )
        {
            stack.push( -num );
        }
        else if ( prevSign == '*' )
        {
            int val = stack.pop();
            val *= num;
            stack.push( val );
        }
        else if ( prevSign == '/' )
        {
            int val = stack.pop();
            val /= num;
            stack.push( val );
        }
    }
}

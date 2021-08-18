package com.amazon.interview.stack;

import java.util.Stack;

public class Leet402
{
    public String removeKdigits( String num, int k )
    {
        if ( k == num.length() ) return "0";
        Stack< Character > stack = new Stack<>();
        stack.push( num.charAt( 0 ) );
        for ( int i = 1; i < num.length(); i++ )
        {
            while ( !stack.isEmpty() && stack.peek() > num.charAt( i ) && k > 0 )
            {
                stack.pop();
                k--;
            }

            stack.push( num.charAt( i ) );
        }
        while ( k > 0 )
        {
            stack.pop();
            k--;
        }
        String s = "";
        while ( !stack.isEmpty() )
        {
            char c = stack.pop();
            s = c + s;
        }
        int i;
        for ( i = 0; i < s.length(); i++ )
        {
            if ( s.charAt( i ) != '0' ) break;

        }
        String res = s.substring( i );
        return res.equals( "" ) ? "0" : res;
    }
}

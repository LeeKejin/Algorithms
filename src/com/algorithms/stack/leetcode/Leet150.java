package com.algorithms.stack.leetcode;

import java.util.Stack;

public class Leet150
{
    public int evalRPN( String[] tokens )
    {
        Stack< Integer > stack = new Stack<>();
        for ( String token : tokens )
        {
            if ( !token.equals( "+" ) && !token.equals( "-" ) && !token.equals( "*" ) && !token.equals( "/" ) )
            {
                stack.push( Integer.parseInt( token ) );
            }
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int val = 0;
                if ( token.equals( "+" ) )
                {
                    val = val1 + val2;
                }
                else if ( token.equals( "-" ) )
                {
                    val = val2 - val1;
                }
                else if ( token.equals( "*" ) )
                {
                    val = val2 * val1;
                }
                else if ( token.equals( "/" ) )
                {
                    val = val2 / val1;
                }
                stack.push( val );
            }
        }
        return stack.pop();
    }
}

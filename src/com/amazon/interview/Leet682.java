package com.amazon.interview;

import java.util.Stack;

public class Leet682
{
    public int calPoints( String[] ops )
    {
        Stack< Integer > stack = new Stack<>();
        int res = 0;
        for ( String op : ops )
        {
            if ( op.equals( "D" ) )
            {
                stack.push( stack.peek() * 2 );
            }
            else if ( op.equals( "C" ) )
            {
                stack.pop();
            }
            else if ( op.equals( "+" ) )
            {
                int a = stack.pop();
                int b = stack.pop();
                int c = a + b;
                stack.push( b );
                stack.push( a );
                stack.push( c );
            }
            else
            {
                stack.push( Integer.parseInt( op ) );
            }
        }
        while ( !stack.isEmpty() )
        {
            res += stack.pop();
        }
        return res;
    }
}

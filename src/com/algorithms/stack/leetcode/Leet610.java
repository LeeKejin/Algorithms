package com.algorithms.stack.leetcode;

import java.util.Stack;

public class Leet610
{
    public String decodeString( String s )
    {
        Stack< Character > stack = new Stack<>();
        String res = "";
        for ( int i = s.length() - 1; i >= 0; i-- )
        {
            if ( Character.isLetter( s.charAt( i ) ) || s.charAt( i ) == ']' || s.charAt( i ) == '[' )
            {
                stack.push( s.charAt( i ) );
            }
            else if ( Character.isDigit( s.charAt( i ) ) )
            {
                String cur = String.valueOf( s.charAt( i ) );
                String num = extractNum( s, i, cur );
                i = i - num.length() + 1;
                int val = Integer.valueOf( num );
                StringBuilder temp = new StringBuilder();
                while ( !stack.isEmpty() )
                {
                    if ( stack.peek() == '[' )
                    {
                        stack.pop();
                        continue;
                    }

                    if ( !stack.isEmpty() && stack.peek() == ']' )
                    {
                        stack.pop();
                        break;
                    }
                    temp.append( stack.pop() );
                }
                StringBuffer loop = new StringBuffer();
                for ( int j = 0; j < val; j++ )
                {
                    loop.append( temp );
                }
                for ( int j = loop.length() - 1; j >= 0; j-- )
                {
                    stack.push( loop.charAt( j ) );
                }
            }
        }
        StringBuffer loop = new StringBuffer();
        while ( !stack.isEmpty() )
        {
            loop.append( stack.pop() );
        }
        if ( loop.toString().length() > 0 ) return loop.toString() + res;
        return res;
    }

    private String extractNum( String s, int i, String cur )
    {
        if ( i - 1 >= 0 && Character.isDigit( s.charAt( i - 1 ) ) )
        {
            i--;
            String p = String.valueOf( s.charAt( i ) );
            return extractNum( s, i, p + cur );
        }
        return cur;

    }
}

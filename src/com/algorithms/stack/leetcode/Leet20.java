package com.algorithms.stack.leetcode;

import java.util.Stack;

public class Leet20
{
    public boolean isValid( String s )
    {
        if ( s == null || s.length() == 0 ) return true;

        Stack< Character > stack = new Stack<>();
        for ( int i = 0; i < s.length(); i++ )
        {
            char ch = s.charAt( i );
            if ( ch == '(' || ch == '[' || ch == '{' )
            {
                stack.push( ch );
            }
            if ( ch == ')' || ch == ']' || ch == '}' )
            {
                if ( stack.isEmpty() ) return false;
                char existedVal = stack.pop();
                if ( ch == ')' && existedVal != '(' ) return false;
                if ( ch == ']' && existedVal != '[' ) return false;
                if ( ch == '}' && existedVal != '{' ) return false;
            }
        }
        return stack.isEmpty();
    }
}

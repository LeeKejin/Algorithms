package com.algorithms.sword.means.offer;

import java.util.Stack;

public class Offer31_C
{
    public boolean validateStackSequences( int[] pushed, int[] popped )
    {
        Stack< Integer > stack = new Stack<>();
        int n = 0;
        for ( int i = 0; i < pushed.length; i++ )
        {

            stack.push( pushed[ i ] );
            while ( !stack.isEmpty() && stack.peek() == popped[ n ] )
            {
                stack.pop();
                n++;
            }
        }
        return stack.isEmpty();
    }
}

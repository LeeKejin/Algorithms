package com.algorithms.sword.means.offer;

import java.util.Stack;

public class Offer33_C
{
    public boolean verifyPostorder( int[] postorder )
    {
        if ( postorder.length == 0 || postorder.length == 1 ) return true;
        return verify( postorder, 0, postorder.length - 1 );
    }

    private boolean verify( int[] postorder, int i, int j )
    {
        if ( i >= j ) return true;
        int m = i;
        while ( postorder[ m ] < postorder[ j ] )
        {
            m++;
        }
        int p = m;
        while ( postorder[ p ] > postorder[ j ] )
        {
            p++;
        }
        return p == j && verify( postorder, i, m - 1 ) && verify( postorder, m, j );
    }

    public boolean verifyPostorder1( int[] postorder )
    {
        if ( postorder.length == 0 || postorder.length == 1 ) return true;
        Stack< Integer > stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for ( int i = postorder.length - 1; i >= 0; i-- )
        {
            if ( postorder[ i ] >= root ) return false;
            if ( postorder[ i ] < root )
            {

                while ( !stack.isEmpty() && stack.peek() > postorder[ i ] )
                {
                    root = stack.pop();
                }
                stack.push( postorder[ i ] );
            }
        }
        return true;
    }
}

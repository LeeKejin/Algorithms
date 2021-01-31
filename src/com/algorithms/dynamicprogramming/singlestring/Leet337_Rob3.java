package com.algorithms.dynamicprogramming.singlestring;

import java.util.HashMap;
import java.util.Map;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Leet337_Rob3
{
    Map< TreeNode, Integer > map = new HashMap<>();

    public int rob( TreeNode root )
    {
        if ( root == null ) return 0;
        if ( map.get( root ) != null ) return map.get( root );

        int sum1 = root.val;

        if ( root.left != null )
        {
            sum1 += rob( root.left.left );
            sum1 += rob( root.left.right );
        }
        if ( root.right != null )
        {

            sum1 += rob( root.right.left );
            sum1 += rob( root.right.right );
        }
        int sum2 = rob( root.left ) + rob( root.right );

        map.put( root, Math.max( sum1, sum2 ) );
        return map.get( root );
    }

    public int robBetterSolution( TreeNode root )
    {
        if ( root == null ) return 0;

        int dp[] = dfs( root );

        return Math.max( dp[ 0 ], dp[ 1 ] );
    }

    private int[] dfs( TreeNode node )
    {

        if ( node == null ) return new int[] { 0, 0 };
        int[] left = dfs( node.left );
        int[] right = dfs( node.right );

        int rob = node.val + left[ 0 ] + right[ 0 ];
        int notRob =
            Math.max( left[ 0 ], left[ 1 ] ) + Math.max( right[ 0 ], right[ 1 ] );

        return new int[] { notRob, rob };
    }

}

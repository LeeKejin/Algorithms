package com.amazon.interview.dfs;

import com.algorithms.sword.means.offer.TreeNode;

public class Leet124
{
    int max = Integer.MIN_VALUE;

    public int maxPathSum( TreeNode root )
    {
        if ( root == null ) return 0;
        findMax( root );
        return max;
    }

    private int findMax( TreeNode root )
    {
        if ( root == null ) return 0;
        int left = findMax( root.left );
        int right = findMax( root.right );
        max = Math.max( right + left + root.val, max );
        return root.val + Math.max( left, right ) < 0 ? 0 : root.val + Math.max( left, right );
    }
}

package com.algorithms.sword.means.offer;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Offer55
{
    public int maxDepth( com.algorithms.binary.search.tree.leetcode.TreeNode root )
    {
        if ( root == null ) return 0;

        int count = 1;
        int left = maxDepth( root.left, count );
        int right = maxDepth( root.right, count );
        return Math.max( left, right );
    }

    private int maxDepth( TreeNode node, int count )
    {
        if ( node == null ) return count;
        count++;
        return Math.max( maxDepth( node.left, count ), maxDepth( node.right, count ) );
    }
}

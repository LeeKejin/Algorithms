package com.algorithms.binary.search.tree.leetcode;

public class Offer55
{
    public int maxDepth( TreeNode root )
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

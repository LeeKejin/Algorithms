package com.algorithms.binary.search.tree.leetcode;

public class Leet108_1
{
    public TreeNode sortedArrayToBST( int[] nums )
    {
        return generateTree( 0, nums.length - 1, nums );
    }

    private TreeNode generateTree( int l, int r, int[] nums )
    {
        if ( l < 0 || r > nums.length - 1 || l > r ) return null;
        int mid = l + ( r - l ) / 2;
        TreeNode node = new TreeNode( nums[ mid ] );
        node.left = generateTree( l, mid - 1, nums );
        node.right = generateTree( mid + 1, r, nums );
        return node;
    }
}

package com.algorithms.sword.means.offer;

public class Offer28
{
    public boolean isSymmetric( com.algorithms.sword.means.offer.TreeNode root )
    {
        if ( root == null ) return true;
        return dfs( root.left, root.right );
    }

    private boolean dfs( com.algorithms.sword.means.offer.TreeNode left, TreeNode right )
    {
        if ( left == null && right == null ) return true;
        if ( ( left == null || right == null ) || left.val != right.val ) return false;
        return dfs( left.left, right.right ) && dfs( left.right, right.left );
    }
}

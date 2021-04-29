package com.algorithms.sword.means.offer;

public class Offer26
{
    public boolean isSubStructure( TreeNode A, TreeNode B )
    {
        if ( A == null || B == null ) return false;
        return dfs( A, B ) || isSubStructure( A.left, B ) || isSubStructure( A.right, B );
    }

    private boolean dfs( TreeNode A, TreeNode B )
    {
        if ( B == null ) return true;
        if ( A == null || A.val != B.val ) return false;
        return dfs( A.left, B.left ) && dfs( A.right, B.right );
    }
}

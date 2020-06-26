package com.algorithms.binary.search.tree.leetcode;

public class Leet235
{

    public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q )
    {
        if ( ( p.val < root.val && q.val > root.val ) || ( p.val > root.val && q.val < root.val ) ) return root;

        if ( p.val < root.val && q.val < root.val ) return lowestCommonAncestor( root.left, p, q );
        if ( p.val > root.val && q.val > root.val ) return lowestCommonAncestor( root.right, p, q );
        return root;
    }
}

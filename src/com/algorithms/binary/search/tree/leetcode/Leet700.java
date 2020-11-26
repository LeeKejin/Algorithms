package com.algorithms.binary.search.tree.leetcode;

public class Leet700
{
    public TreeNode searchBST( TreeNode root, int val )
    {
        if ( root == null ) return null;
        if ( val == root.val ) return root;
        if ( val > root.val ) return searchBST( root.right, val );
        return searchBST( root.left, val );
    }
}

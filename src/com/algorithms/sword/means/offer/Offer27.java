package com.algorithms.sword.means.offer;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Offer27
{
    public TreeNode mirrorTree( TreeNode root )
    {
        dfs( root );
        return root;
    }

    private TreeNode dfs( TreeNode node )
    {
        if ( node == null ) return null;
        TreeNode temp = node.left;
        node.left = dfs( node.right );
        node.right = dfs( temp );
        return node;

    }
}

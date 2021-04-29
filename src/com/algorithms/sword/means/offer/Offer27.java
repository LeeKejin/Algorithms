package com.algorithms.sword.means.offer;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Offer27
{
    public TreeNode mirrorTree( TreeNode root )
    {
        if ( root == null ) return null;
        return mirrorTree( root, new TreeNode( root.val ) );
    }

    private TreeNode mirrorTree( TreeNode original, TreeNode mirror )
    {
        if ( original.left != null )
        {
            mirror.right = mirrorTree( original.left, new TreeNode( original.left.val ) );
        }

        if ( original.right != null )
        {
            mirror.left = mirrorTree( original.right, new TreeNode( original.right.val ) );
        }
        return mirror;
    }
}

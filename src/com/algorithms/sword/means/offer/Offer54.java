package com.algorithms.sword.means.offer;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Offer54
{
    List< Integer > list = new ArrayList<>();

    public int kthLargest( com.algorithms.binary.search.tree.leetcode.TreeNode root, int k )
    {
        if ( root == null ) return -1;
        inOrderRetrieve( root, k );
        return list.get( list.size() - 1 );
    }

    private void inOrderRetrieve( TreeNode node, int k )
    {
        if ( node == null ) return;
        inOrderRetrieve( node.right, k );
        if ( list.size() < k ) list.add( node.val );
        inOrderRetrieve( node.left, k );

    }
}

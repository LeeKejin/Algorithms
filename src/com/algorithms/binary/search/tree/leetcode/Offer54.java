package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Offer54
{
    List< Integer > list = new ArrayList<>();

    public int kthLargest( TreeNode root, int k )
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

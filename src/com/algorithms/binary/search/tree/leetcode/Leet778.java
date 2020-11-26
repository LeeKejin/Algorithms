package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet778
{
    List< Integer > list = new ArrayList<>();

    public List< Integer > inorderTraversal( TreeNode root )
    {
        inOrder( root );

        return list;
    }

    private void inOrder( TreeNode node )
    {
        if ( node == null ) return;
        inOrder( node.left );
        list.add( node.val );
        inOrder( node.right );
    }
}

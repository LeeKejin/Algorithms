package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet144
{
    List< Integer > list = new ArrayList<>();

    public List< Integer > preorderTraversal( TreeNode root )
    {
        preOrder( root );

        return list;
    }

    private void preOrder( TreeNode node )
    {
        if ( node == null ) return;
        list.add( node.val );
        preOrder( node.left );
        preOrder( node.right );
    }
}

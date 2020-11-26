package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet145
{
    List< Integer > list = new ArrayList<>();

    public List< Integer > postorderTraversal( TreeNode root )
    {
        postOrder( root );

        return list;
    }

    private void postOrder( TreeNode node )
    {
        if ( node == null ) return;
        postOrder( node.left );
        postOrder( node.right );
        list.add( node.val );
    }
}

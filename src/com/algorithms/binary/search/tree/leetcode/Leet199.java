package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet199
{
    List< Integer > list = new ArrayList<>();

    public List< Integer > rightSideView( TreeNode root )
    {
        if ( root == null ) return list;
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            for ( int i = 0; i < size; i++ )
            {
                TreeNode node = queue.poll();
                if ( i == size - 1 ) list.add( node.val );
                if ( node.left != null ) queue.add( node.left );
                if ( node.right != null ) queue.add( node.right );
            }
        }
        return list;
    }
}

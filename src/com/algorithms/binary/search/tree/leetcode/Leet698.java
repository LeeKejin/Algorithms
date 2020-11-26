package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet698
{
    List< List< Integer > > result = new ArrayList<>();

    public List< List< Integer > > levelOrder( TreeNode root )
    {
        if ( root == null ) return result;
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        while ( !queue.isEmpty() )
        {
            List< Integer > innerList = new ArrayList<>();
            int size = queue.size();
            for ( int i = 0; i < size; i++ )
            {
                TreeNode node = queue.poll();
                innerList.add( node.val );
                if ( node.left != null ) queue.add( node.left );
                if ( node.right != null ) queue.add( node.right );
            }
            result.add( innerList );
        }
        return result;
    }
}

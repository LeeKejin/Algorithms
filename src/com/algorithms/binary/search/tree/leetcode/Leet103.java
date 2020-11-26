package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet103
{
    List< List< Integer > > results = new ArrayList<>();

    public List< List< Integer > > zigzagLevelOrder( TreeNode root )
    {
        if ( root == null ) return results;
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
            if ( results.size() % 2 != 0 )
            {
                Collections.reverse( innerList );
            }
            results.add( innerList );
        }
        return results;
    }
}

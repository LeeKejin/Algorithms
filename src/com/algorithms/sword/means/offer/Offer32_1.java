package com.algorithms.sword.means.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_1
{
    public int[] levelOrder( TreeNode root )
    {
        if ( root == null ) return new int[] {};
        List< Integer > list = new ArrayList<>();
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        while ( !queue.isEmpty() )
        {
            TreeNode node = queue.poll();
            list.add( node.val );
            if ( node.left != null ) queue.add( node.left );
            if ( node.right != null ) queue.add( node.right );
        }
        int[] arr = new int[ list.size() ];
        for ( int i = 0; i < list.size(); i++ )
        {
            arr[ i ] = list.get( i );
        }
        return arr;
    }
}

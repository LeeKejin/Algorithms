package com.algorithms.sword.means.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_3
{
    public List< List< Integer > > levelOrder( TreeNode root )
    {
        if ( root == null ) return new ArrayList<>();
        List< List< Integer > > res = new ArrayList<>();
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            //            List< Integer > list = new ArrayList<>();
            Deque< Integer > deque = new LinkedList<>();

            for ( int i = 0; i < size; i++ )
            {
                TreeNode node = queue.poll();
                if ( res.size() % 2 == 1 )
                {
                    deque.addFirst( node.val );
                }
                else
                {
                    deque.addLast( node.val );
                }

                if ( node.left != null ) queue.add( node.left );
                if ( node.right != null ) queue.add( node.right );

            }
            res.add( new ArrayList<>( deque ) );
        }

        return res;
    }

}

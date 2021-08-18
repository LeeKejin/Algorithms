package com.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Leet314
{
    List< List< Integer > > verticalOrder( TreeNode root )
    {
        if ( root == null )
        {
            return new ArrayList<>();
        }
        Map< TreeNode, Integer > nodeMap = new HashMap<>();
        Map< Integer, List< Integer > > res = new TreeMap<>();
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        nodeMap.put( root, 0 );
        while ( !queue.isEmpty() )
        {
            TreeNode node = queue.poll();
            int i = nodeMap.get( node );
            if ( res.containsKey( i ) )
            {
                res.get( i ).add( node.val );
            }
            else
            {
                res.put( i, new ArrayList<>() );
                res.get( i ).add( node.val );
            }
            if ( node.left != null )
            {
                queue.add( node.left );
                nodeMap.put( node.left, i - 1 );
            }
            if ( node.right != null )
            {
                queue.add( node.right );
                nodeMap.put( node.right, i + 1 );
            }
        }
        return new ArrayList<>( res.values() );
    }
}

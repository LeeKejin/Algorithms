package com.amazon.interview.dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.algorithms.sword.means.offer.TreeNode;

public class Leet863
{
    List< Integer > res = new ArrayList<>();

    public List< Integer > distanceK( TreeNode root, TreeNode target, int k )
    {
        Map< TreeNode, TreeNode > map = new HashMap<>();
        generateFamilyMap( root, root.left, root.right, map );
        Set< Integer > visited = new HashSet<>();
        dfs( target, map, k, visited );
        return res;
    }

    private void dfs( TreeNode target, Map< TreeNode, TreeNode > map, int k, Set< Integer > visited )
    {
        if ( target == null || visited.contains( target.val ) ) return;
        visited.add( target.val );
        if ( k == 0 )
        {
            res.add( target.val );
            return;
        }
        dfs( target.left, map, k - 1, visited );
        dfs( target.right, map, k - 1, visited );
        dfs( map.get( target ), map, k - 1, visited );
    }

    private void generateFamilyMap( TreeNode root, TreeNode left, TreeNode right, Map< TreeNode, TreeNode > map )
    {
        if ( right != null )
        {
            map.put( right, root );
            generateFamilyMap( right, right.left, right.right, map );
        }
        if ( left != null )
        {
            map.put( left, root );
            generateFamilyMap( left, left.left, left.right, map );
        }
    }

    public List< Integer > distanceKBFS( TreeNode root, TreeNode target, int k )
    {
        Map< TreeNode, TreeNode > map = new HashMap<>();
        Set< Integer > visited = new HashSet<>();
        generateFamilyMap( root, map );
        Deque< TreeNode > deque = new LinkedList<>();
        deque.add( target );
        while ( !deque.isEmpty() )
        {
            if ( k == 0 )
            {
                while ( !deque.isEmpty() )
                {
                    res.add( deque.poll().val );
                }
            }
            k--;
            int size = deque.size();
            for ( int i = 0; i < size; i++ )
            {
                TreeNode node = deque.poll();
                visited.add( node.val );
                if ( node.left != null && !visited.contains( node.left.val ) )
                {
                    deque.add( node.left );
                }
                if ( node.right != null && !visited.contains( node.right.val ) )
                {
                    deque.add( node.right );
                }
                if ( map.get( node ) != null && !visited.contains( map.get( node ).val ) )
                {
                    deque.add( map.get( node ) );
                }
            }
        }

        return res;
    }

    private void generateFamilyMap( TreeNode root, Map< TreeNode, TreeNode > map )
    {
        if ( root == null ) return;
        if ( root.left != null )
        {
            map.put( root.left, root );
            generateFamilyMap( root.left, map );
        }
        if ( root.right != null )
        {
            map.put( root.right, root );
            generateFamilyMap( root.right, map );
        }
    }

}

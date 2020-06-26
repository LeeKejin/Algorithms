package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet113
{
    public static List< List< Integer > > pathSumOriginal( TreeNode root, int sum )
    {
        return find( root, sum );
    }

    public static List< List< Integer > > find( TreeNode node, int sum )
    {
        if ( node == null ) return new ArrayList<>();
        List< List< Integer > > list = new ArrayList<>();

        if ( node.left == null && node.right == null )
        {
            sum -= node.val;
            if ( sum == 0 )
            {
                List< Integer > subList = new ArrayList<>();
                subList.add( node.val );
                list.add( subList );
                return list;
            }
            return new ArrayList<>();
        }

        if ( node.left != null )
        {
            List< List< Integer > > leftList = find( node.left, sum - node.val );
            for ( List< Integer > sub : leftList )
            {
                List< Integer > parentLeftList = new ArrayList<>();
                sub.add( 0, node.val );
                parentLeftList.addAll( sub );
                if ( !parentLeftList.isEmpty() )
                {
                    list.add( parentLeftList );
                }
            }

        }

        if ( node.right != null )
        {
            List< List< Integer > > rightList = find( node.right, sum - node.val );
            for ( List< Integer > sub : rightList )
            {
                List< Integer > parentRightList = new ArrayList<>();
                sub.add( 0, node.val );
                parentRightList.addAll( sub );
                if ( !parentRightList.isEmpty() )
                {
                    list.add( parentRightList );
                }
            }

        }
        return list;
    }

    static List< List< Integer > > res = new ArrayList<>();

    public static List< List< Integer > > pathSumBetterSolution( TreeNode root, int sum )
    {
        if ( root == null ) return res;
        List< Integer > list = new ArrayList<>();
        backTrack( root, sum, 0, list );
        return res;
    }

    private static void backTrack( TreeNode node, int sum, int currentSum, List< Integer > list )
    {
        list.add( node.val );
        currentSum += node.val;
        if ( node.left == null && node.right == null )
        {
            if ( currentSum == sum )
            {
                res.add( new ArrayList<>( list ) );
            }
            list.remove( list.size() - 1 );
            return;
        }

        if ( node.left != null )
        {
            backTrack( node.left, sum, currentSum, list );
        }
        if ( node.right != null )
        {
            backTrack( node.right, sum, currentSum, list );
        }
        list.remove( list.size() - 1 );
    }

    public static void main( String[] args )
    {
        //        TreeNode root = new TreeNode( 5 );
        //        root.left = new TreeNode( 4 );
        //        root.right = new TreeNode( 8 );
        //        root.left.left = new TreeNode( 11 );
        //        root.left.left.left = new TreeNode( 7 );
        //        root.left.left.right = new TreeNode( 2 );
        //
        //        root.right.left = new TreeNode( 13 );
        //        root.right.right = new TreeNode( 4 );
        //        root.right.right.right = new TreeNode( 1 );
        //        root.right.right.left = new TreeNode( 5 );

        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 0 );
        //        root.right = new TreeNode( 1 );
        root.left.left = new TreeNode( 1 );
        root.left.right = new TreeNode( 2 );
        root.left.left.left = new TreeNode( 0 );
        root.left.left.right = new TreeNode( 1 );

        root.left.right.left = new TreeNode( -1 );
        root.left.right.right = new TreeNode( 0 );

        System.out.println( pathSumBetterSolution( root, 2 ) );
    }

}

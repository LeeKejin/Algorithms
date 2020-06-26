package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet257
{
    public static List< String > binaryTreePaths( TreeNode root )
    {

        return find( root );

    }

    private static List< String > find( TreeNode node )
    {
        if ( node == null ) return new ArrayList<>();
        List< String > list = new ArrayList<>();
        if ( node.left == null && node.right == null )
        {
            list.add( String.valueOf( node.val ) );
            return list;
        }

        List< String > leftList = find( node.left );
        for ( int i = 0; i < leftList.size(); i++ )
        {
            String s = node.val + "->" + leftList.get( i );
            list.add( s );
        }
        List< String > rightList = find( node.right );
        for ( int i = 0; i < rightList.size(); i++ )
        {
            String s = node.val + "->" + rightList.get( i );
            list.add( s );
        }
        return list;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.left.left = new TreeNode( 5 );
        root.left.right = new TreeNode( 6 );

        System.out.println( binaryTreePaths( root ) );
        //        System.out.println( 1 << 3 );
    }
}

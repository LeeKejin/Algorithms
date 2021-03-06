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

    static List< String > results = new ArrayList<>();

    public List< String > binaryTreePathsEasy( TreeNode root )
    {
        if ( root == null ) return new ArrayList<>();
        findPath( root, "" );
        return results;
    }

    private static void findPath( TreeNode node, String str )
    {
        if ( node.left == null && node.right == null )
        {
            str += node.val;
            results.add( str );
            return;
        }
        if ( node.left != null )
        {
            findPath( node.left, str + node.val + "->" );
        }

        if ( node.right != null )
        {
            findPath( node.right, str + node.val + "->" );
        }
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

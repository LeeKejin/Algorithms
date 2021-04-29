package com.algorithms.binary.search.tree.leetcode;

public class Leet110
{
    public static boolean isBalanced( TreeNode root )
    {
        return getHeight( root ) != -1;
    }

    public static int getHeight( TreeNode node )
    {
        if ( node == null ) return 0;

        int left = getHeight( node.left );
        if ( left == -1 ) return -1;
        int right = getHeight( node.right );
        if ( right == -1 ) return -1;
        return Math.abs( left - right ) <= 1 ? Math.max( left, right ) + 1 : -1;
    }

    public boolean isBalanced1( TreeNode root )
    {
        return depth( root ) != -1;
    }

    int depth( TreeNode node )
    {
        if ( node == null ) return 0;
        int left = depth( node.left );
        if ( left == -1 ) return -1;
        int right = depth( node.right );
        if ( right == -1 ) return -1;
        if ( Math.abs( left - right ) > 1 ) return -1;
        return Math.max( left, right ) + 1;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 2 );
        root.left.left = new TreeNode( 3 );
        root.left.left.left = new TreeNode( 4 );

        System.out.println( isBalanced( root ) );
        //        System.out.println( 1 << 3 );
    }
}

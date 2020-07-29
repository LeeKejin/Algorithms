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

    //This solution is more clear
    public boolean isBalancedSolution1( TreeNode root )
    {
        if ( root == null ) return true;
        int leftDepth = depth( root.left, 0 );
        int rightDepth = depth( root.right, 0 );
        if ( leftDepth == -1 || rightDepth == -1 ) return false;
        return Math.abs( leftDepth - rightDepth ) <= 1;
    }

    private int depth( TreeNode node, int count )
    {
        if ( node == null ) return count;
        int leftDepth = depth( node.left, count + 1 );
        int rightDepth = depth( node.right, count + 1 );
        int depth = Math.abs( leftDepth - rightDepth );
        return depth <= 1 ? Math.max( leftDepth, rightDepth ) : -1;
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

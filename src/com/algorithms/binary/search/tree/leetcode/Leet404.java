package com.algorithms.binary.search.tree.leetcode;

public class Leet404
{
    public static int sumOfLeftLeaves( TreeNode root )
    {
        return helper( root );
    }

    public static int helper( TreeNode node )
    {
        int sum = 0;
        if ( node == null )
        {
            return 0;
        }
        if ( node.left != null && ( node.left.left == null && node.left.right == null ) )
        {
            sum += node.left.val;
        }
        sum += helper( node.left ) + helper( node.right );
        return sum;
    }

    static int sum = 0;

    public static int sumOfLeftLeavesEasySolution( TreeNode root )
    {
        if ( root == null ) return 0;
        if ( root.left == null && root.right == null ) return 0;
        sumUp( root );
        return sum;
    }

    private static void sumUp( TreeNode root )
    {
        if ( root == null ) return;
        if ( root.left == null && root.right == null )
        {
            sum += root.val;
        }
        sumUp( root.left );
        if ( root.right != null && ( root.right.left != null || root.right.right != null ) )
        {
            sumUp( root.right );
        }
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 0 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 4 );
        root.left.left = new TreeNode( 1 );
        root.left.left.left = new TreeNode( 5 );
        root.left.left.right = new TreeNode( 1 );

        root.right.left = new TreeNode( 3 );
        root.right.right = new TreeNode( -1 );
        root.right.left.right = new TreeNode( 6 );
        root.right.right.right = new TreeNode( 8 );
        System.out.println( sumOfLeftLeaves( root ) );
    }
}

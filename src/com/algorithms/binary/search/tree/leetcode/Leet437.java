package com.algorithms.binary.search.tree.leetcode;

public class Leet437
{
    static int count = 0;

    public static int pathSum( TreeNode root, int sum )
    {
        if ( root == null ) return 0;

        findPath( root, sum );
        pathSum( root.left, sum );
        pathSum( root.right, sum );
        return count;
    }

    private static void findPath( TreeNode node, int sum )
    {
        if ( node == null ) return;
        if ( sum == node.val )
        {
            count++;
        }
        sum -= node.val;
        findPath( node.left, sum );
        findPath( node.right, sum );
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 10 );
        root.left = new TreeNode( 5 );
        root.right = new TreeNode( -3 );
        root.left.left = new TreeNode( 3 );
        root.left.right = new TreeNode( 2 );
        root.left.left.left = new TreeNode( 3 );
        root.left.left.right = new TreeNode( -2 );
        root.left.right.right = new TreeNode( 1 );
        root.right.right = new TreeNode( 11 );

        pathSum( root, 8 );

    }

}

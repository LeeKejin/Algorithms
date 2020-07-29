package com.algorithms.binary.search.tree.leetcode;

public class Leet437
{
    int count = 0;

    public int pathSum( TreeNode root, int sum )
    {
        if ( root == null ) return 0;

        findPath( root, sum );
        pathSum( root.left, sum );
        pathSum( root.right, sum );
        return count;
    }

    private void findPath( TreeNode node, int sum )
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

    int total = 0;

    public int pathSumEasySolution( TreeNode root, int sum )
    {
        if ( root == null ) return 0;
        retrieveNode( root, sum );

        return total;
    }

    private void retrieveNode( TreeNode root, int sum )
    {
        if ( root == null ) return;
        numberOfPath( root, sum );
        retrieveNode( root.left, sum );
        retrieveNode( root.right, sum );
    }

    private void numberOfPath( TreeNode root, int sum )
    {
        if ( root == null ) return;
        if ( root.val == sum )
        {
            total++;
        }
        numberOfPath( root.left, sum - root.val );
        numberOfPath( root.right, sum - root.val );
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

    }

}

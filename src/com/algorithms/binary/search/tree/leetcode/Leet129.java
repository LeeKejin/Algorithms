package com.algorithms.binary.search.tree.leetcode;

public class Leet129
{

    public static int sumNumbers( TreeNode root )
    {
        return sum( root, 0 );
    }

    private static int sum( TreeNode node, int i )
    {
        if ( node == null ) return 0;
        int temp = node.val + i * 10;
        if ( node.left == null && node.right == null )
        {
            return temp;
        }
        int l = sum( node.left, temp );
        int r = sum( node.right, temp );
        return l + r;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 4 );
        root.left = new TreeNode( 9 );
        root.right = new TreeNode( 0 );
        root.left.left = new TreeNode( 5 );
        root.left.right = new TreeNode( 1 );
        sumNumbers( root );

    }
}

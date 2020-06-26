package com.algorithms.binary.search.tree.leetcode;

public class Leet108
{
    public static TreeNode sortedArrayToBST( int[] nums )
    {
        return insert( 0, nums.length - 1, nums );
    }

    private static TreeNode insert( int start, int end, int[] nums )
    {
        if ( start > end ) return null;
        int index = ( end + start ) / 2;
        TreeNode root = new TreeNode( nums[ index ] );
        root.left = insert( start, index - 1, nums );
        root.right = insert( index + 1, end, nums );
        return root;
    }

    public static void main( String[] args )
    {
        int[] arr = new int[] { -10, -3, 0, 5, 9 };
        //        int[] arr = new int[] { 1, 3 };
        TreeNode root = sortedArrayToBST( arr );
        System.out.println( root );

    }
}

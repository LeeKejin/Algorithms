package com.algorithms.binary.search.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet101
{
    public static boolean isSymmetric( TreeNode root )
    {
        return isSymmetric( root, root );

    }

    private static boolean isSymmetric( TreeNode left, TreeNode right )
    {
        if ( left == null && right == null ) return true;
        if ( ( left == null && right != null ) || left != null && right == null ) return false;

        return right.val == left.val && isSymmetric( left.left, right.right ) && isSymmetric( right.left, left.right );
    }

    public static boolean isSymmetricWithQueue( TreeNode root )
    {
        return check( root, root );

    }

    private static boolean check( TreeNode left, TreeNode right )
    {
        Queue< TreeNode > queue = new LinkedList< TreeNode >();
        queue.add( left );
        queue.add( right );
        while ( !queue.isEmpty() )
        {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if ( leftNode == null && rightNode == null ) continue;
            if ( leftNode == null || rightNode == null || leftNode.val != rightNode.val ) return false;
            if ( leftNode.val == rightNode.val )
            {
                queue.add( leftNode.left );
                queue.add( rightNode.right );

                queue.add( rightNode.left );
                queue.add( leftNode.right );
            }
        }
        return true;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 2 );
        root.left.left = new TreeNode( 3 );
        root.left.right = new TreeNode( 4 );

        root.right.left = new TreeNode( 4 );
        root.right.right = new TreeNode( 3 );
        isSymmetric( root );
    }
}

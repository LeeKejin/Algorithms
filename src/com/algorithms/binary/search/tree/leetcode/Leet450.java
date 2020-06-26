package com.algorithms.binary.search.tree.leetcode;

public class Leet450
{
    public static TreeNode deleteNode( TreeNode root, int key )
    {
        if ( root == null ) return null;

        if ( root.val == key )
        {
            TreeNode min = findMin( root.right );
            TreeNode right = removeMin( root.right );
            TreeNode left = root.left;

            if ( min != null )
            {
                min.left = left;
                min.right = right;
                return min;
            }
            else
            {
                return left;
            }

        }
        if ( key < root.val )
        {
            root.left = deleteNode( root.left, key );
        }
        else
        {
            root.right = deleteNode( root.right, key );
        }

        return root;
    }

    private static TreeNode removeMin( TreeNode root )
    {
        if ( root == null ) return null;
        if ( root.left == null )
        {
            return root.right;
        }
        else
        {
            root.left = removeMin( root.left );
            return root;
        }
    }

    public static TreeNode findMin( TreeNode root )
    {
        if ( root == null ) return null;
        if ( root.left != null ) return findMin( root.left );
        return root;

    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 5 );
        root.left = new TreeNode( 3 );
        root.right = new TreeNode( 6 );
        root.left.left = new TreeNode( 2 );
        root.left.right = new TreeNode( 4 );

        root.right.right = new TreeNode( 7 );

        //        TreeNode root = new TreeNode( 2 );
        //        root.left = new TreeNode( 1 );
        deleteNode( root, 3 );
        //        System.out.println( 1 << 3 );
    }
}

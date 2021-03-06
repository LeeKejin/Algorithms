package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet230
{
    public static int kthSmallest( TreeNode root, int k )
    {
        List< Integer > list = new ArrayList<>();
        inOrder( root, list );
        return list.get( list.size() - 1 );
    }

    private static void inOrder( TreeNode root, List< Integer > list )
    {
        inOrder( root.left, list );
        list.add( root.val );
        inOrder( root.right, list );

    }

    public static int kthSmallest1( TreeNode root, int k )
    {
        int left = nodeNumber( root.left );
        if ( left + 1 == k )
        {
            return root.val;
        }
        if ( left + 1 < k )
        {
            return kthSmallest1( root.right, k - left - 1 );
        }

        return kthSmallest1( root.left, k );

    }

    public static int nodeNumber( TreeNode node )
    {
        if ( node == null )
        {
            return 0;
        }

        return nodeNumber( node.left ) + nodeNumber( node.right ) + 1;
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 5 );
        root.left = new TreeNode( 3 );
        root.right = new TreeNode( 6 );
        root.left.left = new TreeNode( 2 );
        root.left.right = new TreeNode( 4 );

        root.left.left.left = new TreeNode( 1 );

        kthSmallest( root, 3 );
        //        System.out.println( 1 << 3 );
    }
}

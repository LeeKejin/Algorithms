package com.algorithms.binary.search.tree.leetcode;

import java.util.Stack;

public class Test
{

    public TreeNode buildTree( int[] preorder, int[] inorder )
    {
        if ( preorder.length == 0 || inorder.length == 0 ) return null;
        Stack< TreeNode > stack = new Stack<>();
        TreeNode root = new TreeNode( preorder[ 0 ] );
        stack.push( root );
        int indexInorder = 0;
        for ( int i = 1; i < preorder.length; i++ )
        {
            if ( !stack.isEmpty() )
            {
                TreeNode node = stack.peek();
                if ( node.val != inorder[ indexInorder ] )
                {
                    node.left = new TreeNode( preorder[ i ] );
                    stack.push( node.left );
                }
                else
                {
                    while ( !stack.isEmpty() && stack.peek().val == inorder[ indexInorder ] )
                    {
                        node = stack.pop();
                        indexInorder++;
                    }
                    node.right = new TreeNode( preorder[ i ] );
                    stack.push( node.right );
                }
            }
        }
        return root;
    }

    public static void main( String[] args )
    {

        Test t = new Test();
        TreeNode root = new TreeNode( 3 );
        root.left = new TreeNode( 9 );
        root.right = new TreeNode( 20 );
        root.left.left = new TreeNode( 15 );
        root.left.right = new TreeNode( 10 );
        root.right.right = new TreeNode( 7 );
        root.right.right.right = new TreeNode( 8 );
        root.right.right.left = new TreeNode( 5 );
        root.right.right.right.right = new TreeNode( 4 );

        //        inorder( root );

        //        root.right.left = new TreeNode( 6 );
        //        root.right.right = new TreeNode( 9 );

        //        int b = t.maxDepth( root, 1 );
        //        System.out.println( b );
        //
        //        root.right.right = new TreeNode( 3 );
        //        root.right.right.right = new TreeNode( 4 );
        //        List< List< Integer > > l = t.levelOrder( root );
        //        System.out.println( l );
        //        boolean b = t.isBalanced( root );
        //        System.out.println( b );
        //        TreeNode root = new TreeNode( 2 );
        //        root.left = new TreeNode( 1 );
        //        root.right = new TreeNode( 3 );
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        t.buildTree( inorder, postorder );
    }

    private static void inorder( TreeNode root )
    {
        if ( root == null ) return;
        inorder( root.left );
        System.out.println( root.val );
        inorder( root.right );
    }
}

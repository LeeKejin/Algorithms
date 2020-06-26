package com.algorithms.sword.means.offer;

import java.util.HashMap;
import java.util.Map;

public class Leet7
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode( int x )
        {
            val = x;
        }
    }

    Map< Integer, Integer > map = new HashMap<>();
    int[] preOrder;

    public TreeNode buildTree( int[] preorder, int[] inorder )
    {
        preOrder = preorder;
        for ( int i = 0; i < inorder.length; i++ )
        {
            map.put( inorder[ i ], i );
        }
        return buildTree( 0, 0, inorder.length - 1 );

    }

    private TreeNode buildTree( Integer preRoot, int inLeft, int inRight )
    {
        if ( inLeft > inRight )
        {
            return null;
        }
        TreeNode root = new TreeNode( preOrder[ preRoot ] );
        int inOrderIndex = map.get( preOrder[ preRoot ] );
        root.left = buildTree( preRoot + 1, inLeft, inOrderIndex - 1 );
        root.right = buildTree( inOrderIndex - inLeft + preRoot + 1, inOrderIndex + 1, inRight );
        return root;
    }

    public static void main( String[] args )
    {

    }

}

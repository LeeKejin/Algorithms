package com.algorithms.sword.means.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer7
{
    Map< Integer, Integer > map = new HashMap<>();

    public TreeNode buildTree( int[] preorder, int[] inorder )
    {
        for ( int i = 0; i < inorder.length; i++ )
        {
            map.put( inorder[ i ], i );
        }
        return buildTree( preorder, 0, 0, preorder.length - 1 );
    }

    private TreeNode buildTree( int[] preorder, int rootIndexInPreOrder, int left, int right )
    {
        if ( left > right ) return null;
        TreeNode root = new TreeNode( preorder[ rootIndexInPreOrder ] );
        int indexInInOrder = map.get( preorder[ rootIndexInPreOrder ] );
        root.left = buildTree( preorder, rootIndexInPreOrder + 1, left, indexInInOrder - 1 );
        //indexInInOrder - left--> 左子树长度，所有坐标都是相对preorder的位置
        root.right =
            buildTree( preorder, rootIndexInPreOrder + ( indexInInOrder - left ) + 1, indexInInOrder + 1, right );
        return root;
    }

}

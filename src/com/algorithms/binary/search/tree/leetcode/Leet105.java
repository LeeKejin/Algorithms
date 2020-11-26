package com.algorithms.binary.search.tree.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Leet105
{

    int preorder[];
    int inorder[];
    int pos = 0;
    HashMap< Integer, Integer > map = new HashMap<>();

    public TreeNode buildTree( int[] preorder, int[] inorder )
    {
        if ( preorder.length == 0 || inorder.length == 0 ) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for ( int val : inorder )
        {
            map.put( val, index );
            index++;
        }

        return buildTree( 0, inorder.length - 1 );
    }

    private TreeNode buildTree( int left, int right )
    {
        if ( left > right ) return null;
        int val = preorder[ pos ];
        TreeNode node = new TreeNode( val );
        int index = map.get( val );
        pos++;
        node.left = buildTree( left, index - 1 );
        node.right = buildTree( index + 1, right );
        return node;
    }

    public TreeNode buildTreeRecursive( int[] preorder, int[] inorder )
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
}

package com.algorithms.binary.search.tree.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Leet106
{
    int[] inorder;
    int[] postorder;
    HashMap< Integer, Integer > map = new HashMap<>();
    int pos = 0;

    public TreeNode buildTree( int[] inorder, int[] postorder )
    {
        this.inorder = inorder;
        this.postorder = postorder;
        int index = 0;
        for ( int val : inorder )
        {
            map.put( val, index );
            index++;
        }
        pos = postorder.length - 1;
        return buildTree( 0, inorder.length - 1 );
    }

    private TreeNode buildTree( int left, int right )
    {
        if ( left > right ) return null;
        int rootValue = postorder[ pos ];
        TreeNode root = new TreeNode( rootValue );
        int rootIndex = map.get( rootValue );
        pos--;
        root.right = buildTree( rootIndex + 1, right );

        root.left = buildTree( left, rootIndex - 1 );
        return root;
    }

    public TreeNode buildTreeRecursive( int[] inorder, int[] postorder )
    {
        if ( inorder.length == 0 || postorder.length == 0 ) return null;
        Stack< TreeNode > stack = new Stack<>();
        int val = postorder[ postorder.length - 1 ];
        TreeNode root = new TreeNode( val );
        stack.push( root );
        int inorderIndex = inorder.length - 1;
        for ( int i = postorder.length - 2; i >= 0; i-- )
        {
            if ( !stack.isEmpty() )
            {
                TreeNode node = stack.peek();
                if ( node.val != inorder[ inorderIndex ] )
                {
                    node.right = new TreeNode( postorder[ i ] );
                    stack.push( node.right );
                }
                else
                {
                    while ( !stack.isEmpty() && stack.peek().val == inorder[ inorderIndex ] )
                    {
                        node = stack.pop();
                        inorderIndex--;
                    }
                    node.left = new TreeNode( postorder[ i ] );
                    stack.push( node.left );
                }
            }

        }
        return root;

    }
}

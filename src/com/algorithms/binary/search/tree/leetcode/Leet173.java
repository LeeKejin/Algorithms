package com.algorithms.binary.search.tree.leetcode;

import java.util.Stack;

public class Leet173
{
    TreeNode root;
    Stack< Integer > stack = new Stack<>();

    public Leet173( TreeNode root )
    {
        this.root = root;
        if ( root != null ) pushToStackWithInOrder( root );
    }

    private void pushToStackWithInOrder( TreeNode node )
    {
        if ( node.right != null ) pushToStackWithInOrder( node.right );
        if ( node != null ) stack.push( node.val );
        if ( node.left != null ) pushToStackWithInOrder( node.left );
    }

    /**
     * @return the next smallest number
     */
    public int next()
    {
        return stack.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
}

package com.algorithms.binary.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet98
{
    List< Integer > list = new ArrayList<>();

    public boolean isValidBST( TreeNode root )
    {
        if ( root == null ) return true;
        retrieve( root );
        if ( list.size() == 1 ) return true;
        for ( int i = 1; i < list.size(); i++ )
        {
            if ( list.get( i ) <= list.get( i - 1 ) ) return false;
        }
        return true;
    }

    private void retrieve( TreeNode node )
    {
        if ( node.left != null ) retrieve( node.left );
        list.add( node.val );
        if ( node.right != null ) retrieve( node.right );
    }

    long pre = Long.MIN_VALUE;

    public boolean isValidBSTFasterSolution( TreeNode root )
    {
        if ( root == null )
        {
            return true;
        }
        if ( !isValidBST( root.left ) )
        {
            return false;
        }
        if ( root.val <= pre ) return false;
        pre = root.val;
        return isValidBST( root.right );
    }
}

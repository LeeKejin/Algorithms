package com.amazon.interview;

import com.algorithms.binary.search.tree.leetcode.TreeNode;

public class Leet538
{
    int sum = 0;

    public TreeNode convertBST( TreeNode root )
    {
        if ( root == null ) return null;
        convertBST( root.right );
        sum += root.val;
        root.val = sum;
        convertBST( root.left );
        return root;
    }
}

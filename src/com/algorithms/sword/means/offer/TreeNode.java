package com.algorithms.sword.means.offer;

import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public List< TreeNode > Children = new ArrayList<>();

    public TreeNode( int x )
    {
        val = x;
    }
}

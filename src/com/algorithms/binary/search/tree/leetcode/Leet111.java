package com.algorithms.binary.search.tree.leetcode;


public class Leet111
{
    public int minDepth( TreeNode root )
    {
        if ( root == null ) return 0;
        if ( root.left == null )
        {
            return minDepth( root.right ) + 1;
        }
        if ( root.right == null )
        {
            return minDepth( root.left ) + 1;
        }
        int leftDepth = minDepth( root.left );
        int rightDepth = minDepth( root.right );
        return Math.min( leftDepth, rightDepth ) + 1;
    }

//    public static int minDepthSolutionWithDFS( TreeNode root )
//    {
//        if ( root == null ) return 0;
//        Pair< TreeNode, Integer > rootPair = new Pair<>( root, 0 );
//        Stack< Pair< TreeNode, Integer > > stack = new Stack<>();
//        stack.push( rootPair );
//        int min = Integer.MAX_VALUE;
//        while ( !stack.isEmpty() )
//        {
//            Pair< TreeNode, Integer > pair = stack.pop();
//            TreeNode node = pair.getKey();
//
//            int current = pair.getValue();
//
//            if ( node.left == null && node.right == null )
//            {
//                min = Math.min( min, current );
//            }
//            if ( node.left != null )
//            {
//                stack.push( new Pair<>( node.left, current + 1 ) );
//            }
//
//            if ( node.right != null )
//            {
//                stack.push( new Pair<>( node.right, current + 1 ) );
//            }
//        }
//        return min + 1;
//    }
}

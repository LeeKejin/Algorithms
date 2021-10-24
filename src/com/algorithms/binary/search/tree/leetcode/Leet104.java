package com.algorithms.binary.search.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Leet104
{
    public static int maxDepth( TreeNode root )
    {
        if ( root == null ) return 0;
        int leftMaxDepth = maxDepth( root.left );
        int rightDepth = maxDepth( root.right );
        return Math.max( leftMaxDepth, rightDepth ) + 1;
    }

    public static int maxDepthSolutionWithBFS( TreeNode root )
    {
        if ( root == null ) return 0;
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        int depth = 0;
        while ( !queue.isEmpty() )
        {
            depth++;
            int originalSize = queue.size();
            for ( int i = 0; i < originalSize; i++ )
            {
                TreeNode node = queue.poll();
                if ( node.left != null ) queue.add( node.left );
                if ( node.right != null ) queue.add( node.right );
            }

        }
        return depth;
    }

//    public static int maxDepthSolutionWithDFS( TreeNode root )
//    {
//        if ( root == null ) return 0;
//
//        int maxDepth = 0;
//        Pair< TreeNode, Integer > rootPair = new Pair<>( root, 1 );
//
//        Stack< Pair< TreeNode, Integer > > stack = new Stack<>();
//        stack.push( rootPair );
//        while ( !stack.isEmpty() )
//        {
//            Pair< TreeNode, Integer > pair = stack.pop();
//            TreeNode node = pair.getKey();
//            maxDepth = Math.max( pair.getValue(), maxDepth );
//            int currentDepth = pair.getValue();
//            if ( node.left != null )
//            {
//                stack.push( new Pair<>( node.left, currentDepth + 1 ) );
//            }
//            if ( node.right != null )
//            {
//                stack.push( new Pair<>( node.right, currentDepth + 1 ) );
//            }
//        }
//        return maxDepth;
//    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 0 );
        root.left = new TreeNode( 2 );
        root.left.left = new TreeNode( 1 );
        root.left.left.left = new TreeNode( 5 );
        root.left.left.right = new TreeNode( 1 );

        root.right = new TreeNode( 4 );
        root.right.right = new TreeNode( -1 );
        root.right.right.right = new TreeNode( 8 );
        root.right.left = new TreeNode( 3 );
        root.right.left.right = new TreeNode( 6 );
        System.out.println( maxDepthSolutionWithBFS( root ) );
    }
}

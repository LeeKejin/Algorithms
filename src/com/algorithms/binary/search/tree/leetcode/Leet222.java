package com.algorithms.binary.search.tree.leetcode;

public class Leet222
{
    public static int countNodes( TreeNode root )
    {
        if ( root == null ) return 0;
        return countNodes( root.left ) + countNodes( root.right ) + 1;
    }

    public static int countNodesSolution1( TreeNode root )
    {
        if ( root == null ) return 0;
        int left = countLevel( root.left );
        int right = countLevel( root.right );

        if ( left == right )
        {
            int v = ( int ) Math.pow( 2, left );
            int val = ( int ) ( v + countNodesSolution1( root.right ) );
            return val;
        }
        else
        {
            int v = ( int ) Math.pow( 2, right );
            int val = ( int ) ( v + countNodesSolution1( root.left ) );
            return val;
        }
    }

    private static int countLevel( TreeNode node )
    {
        int count = 0;
        while ( node != null )
        {
            count++;
            node = node.left;
        }
        return count;
    }

    static int result = 0;

    public int countNodesNormalSolution( TreeNode root )
    {
        if ( root == null ) return 0;
        count( root );
        return result;
    }

    public static void count( TreeNode node )
    {
        if ( node.left == null && node.right == null )
        {
            result++;
            return;
        }
        if ( node.left != null && node.right != null )
        {
            result++;
        }
        if ( node.left != null )
        {

            if ( node.right == null && node.left.left == null && node.left.right == null )
            {
                result++;
            }

            count( node.left );

        }

        if ( node.right != null )
        {

            if ( node.left == null && node.right.left == null && node.right.right == null )
            {
                result++;

            }

            count( node.right );
        }
    }

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.left.left = new TreeNode( 4 );
        root.left.right = new TreeNode( 5 );

        root.right.left = new TreeNode( 6 );
        System.out.println( countNodesSolution1( root ) );
    }
}

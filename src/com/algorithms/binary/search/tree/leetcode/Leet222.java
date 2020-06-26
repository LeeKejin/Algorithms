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
            int val = ( int ) ( Math.pow( 2, left ) + countNodesSolution1( root.right ) );
            return val;
        }
        else
        {
            int val = ( int ) ( Math.pow( 2, right ) + countNodesSolution1( root.left ) );
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

    public static void main( String[] args )
    {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );
        root.left.left = new TreeNode( 4 );
        root.left.right = new TreeNode( 5 );

        root.right.left = new TreeNode( 6 );
        System.out.println( countNodesSolution1( root ) );
        //        System.out.println( 1 << 3 );
    }
}

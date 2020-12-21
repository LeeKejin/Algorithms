package com.algorithms.binary.search.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet297
{
    // Encodes a tree to a single string.
    public String serialize( TreeNode root )
    {
        if ( root == null ) return "[]";
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        StringBuilder sb = new StringBuilder();
        int last = 0;
        sb.append( "[" );
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            for ( int i = 0; i < size; i++ )
            {
                TreeNode node = queue.poll();
                if ( node != null )
                {
                    last = node.val;
                    sb.append( node.val + "," );
                    queue.add( node.left );
                    if ( node.left != null ) last = node.left.val;
                    queue.add( node.right );
                    if ( node.right != null ) last = node.right.val;

                }
                else
                {
                    sb.append( "null," );
                }

            }

        }
        int n = sb.toString().length();
        String str = sb.toString().substring( 0, n - 1 );
        int index = str.lastIndexOf( String.valueOf( last ) );
        return str.substring( 0, index ) + last + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize( String data )
    {
        if ( data.equals( "[]" ) || data == null ) return null;
        String convertedData = data.substring( 1, data.length() - 1 );
        String[] arr = convertedData.split( "," );
        Queue< TreeNode > queue = new LinkedList<>();
        TreeNode root = new TreeNode( Integer.parseInt( arr[ 0 ] ) );
        queue.add( root );
        int index = 1;
        while ( index < arr.length )
        {
            TreeNode node = queue.poll();
            if ( !arr[ index ].equals( "null" ) )
            {
                TreeNode left = new TreeNode( Integer.parseInt( arr[ index ] ) );
                node.left = left;
                queue.add( left );
            }
            index++;
            if ( index < arr.length && !arr[ index ].equals( "null" ) )
            {
                TreeNode right = new TreeNode( Integer.parseInt( arr[ index ] ) );
                node.right = right;
                queue.add( right );
            }
            index++;
        }
        return root;
    }
}

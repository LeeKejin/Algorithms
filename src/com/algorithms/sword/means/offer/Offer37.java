package com.algorithms.sword.means.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer37
{
    public String serialize( TreeNode root )
    {
        if ( root == null ) return "null";
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        StringBuilder sb = new StringBuilder();
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            for ( int i = 0; i < size; i++ )
            {
                TreeNode node = queue.poll();
                if ( node != null )
                {
                    sb.append( node.val + "," );
                    queue.add( node.left );
                    queue.add( node.right );
                }
                else
                {
                    sb.append( "null," );
                }
            }
        }
        String str = sb.toString().substring( 0, sb.length() - 1 );

        return "[" + str + "]";
    }

    public TreeNode deserialize( String data )
    {
        if ( data.equals( "null" ) ) return null;
        String str = data.substring( 1, data.length() - 1 );
        String[] arr = str.split( "," );
        TreeNode root = new TreeNode( Integer.parseInt( arr[ 0 ] ) );
        Queue< TreeNode > queue = new LinkedList<>();
        queue.add( root );
        int i = 1;
        while ( i < arr.length )
        {
            TreeNode node = queue.poll();
            if ( arr[ i ].equals( "null" ) )
            {
                node.left = null;
            }
            else
            {
                node.left = new TreeNode( Integer.parseInt( arr[ i ] ) );
                queue.add( node.left );
            }
            i++;
            if ( i < arr.length )
            {
                if ( arr[ i ].equals( "null" ) )
                {
                    node.right = null;
                }
                else
                {
                    node.right = new TreeNode( Integer.parseInt( arr[ i ] ) );
                    queue.add( node.right );
                }
                i++;
            }
        }
        return root;
    }

    public static void main( String[] args )
    {
        Offer37 t = new Offer37();
        t.test();
    }

    private void test()
    {
        TreeNode node = deserialize( "[1,2,3,null,null,4,5]" );
        System.out.println( serialize( node ) );
    }
}

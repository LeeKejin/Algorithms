package com.algorithms.link.structure;

public class Main
{
    public static void main( String[] args )
    {
        LinkedList< Integer > linkedList = new LinkedList<>();
        for ( int i = 0; i < 5; i++ )
        {
            linkedList.addFirst( i );
        }
        System.out.println( linkedList );

        linkedList.add( 1, 6 );
        System.out.println( linkedList );

        linkedList.set( 1, 100 );
        System.out.println( linkedList );

        linkedList.deleteNode( 100 );
        System.out.println( linkedList );
    }
}

package com.algorithms.array;

public class DynamicArrayMain
{
    public static void main( String[] args )
    {
        DynamicArray< Integer > arr = new DynamicArray<>();
        for ( int i = 0; i < 10; i++ )
        {
            arr.addLast( i );
        }
        //        System.out.println( arr.toString() );
        //        arr.add( 1, 100 );
        //        System.out.println( arr.toString() );
        //
        //        arr.add( 0, -1 );
        //        System.out.println( arr.toString() );
        //
        //        arr.remove( 7 );
        //        System.out.println( arr.toString() );
        //
        //        arr.removeElement( 4 );
        System.out.println( arr.toString() );

        arr.add( 0, -1 );
        System.out.println( arr.toString() );
        arr.remove( 7 );
        System.out.println( arr.toString() );
        arr.removeElement( 4 );
        System.out.println( arr.toString() );

    }
}

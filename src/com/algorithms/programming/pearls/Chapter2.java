package com.algorithms.programming.pearls;

public class Chapter2
{
    public static int gcd( int a, int b )
    {
        while ( a != 0 )
        {
            if ( a >= b )
            {
                a -= b;
            }
            else
            {
                int temp = a;
                a = b;
                b = temp;
            }
        }
        return b;

    }

    public static char[] rotate1( char[] a, int length, int rotateLength )
    {
        int gcd = gcd( length, rotateLength );
        for ( int i = 0; i < gcd; i++ )
        {
            char temp = a[ i ];
            int first = i;
            while ( true )
            {
                int second = ( first + rotateLength ) % length;
                if ( second == 0 ) break;
                a[ first ] = a[ second ];
                first = second;
            }
            a[ first ] = temp;
        }
        for ( char ch : a )
        {
            System.out.print( ch );
        }
        return a;
    }

    public static void revert( char[] a, int start, int end )
    {
        while ( start < end )
        {
            char temp = a[ start ];
            a[ start ] = a[ end ];
            a[ end ] = temp;
            start++;
            end--;
        }

    }

    public static void main( String[] args )
    {
        char a[] = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
        //        rotate1( a, 8, 3 );
        revert( a, 0, 2 );

        revert( a, 3, 7 );
        revert( a, 0, 7 );
        for ( char ch : a )
        {
            System.out.print( ch );
        }
    }
}

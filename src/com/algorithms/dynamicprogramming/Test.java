package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
    public int findContentChildren( int[] g, int[] s )
    {
        Arrays.sort( s );
        Arrays.sort( g );
        int count = 0;
        int i = s.length - 1;
        int j = g.length - 1;
        while ( i >= 0 )
        {
            int lastIndex = i;
            while ( j >= 0 )
            {
                if ( i >= 0 && g[ j ] <= s[ i ] )
                {
                    count++;
                    i--;
                }
                else if ( i < 0 )
                {
                    return count;
                }
                j--;
            }
            if ( i == lastIndex )
            {
                return count;
            }
        }
        return count;
    }

    public int shortestWay( String source, String target )
    {
        int index = 0, output = 0;

        while ( index != target.length() )
        {
            output++;
            int lastindex = index;

            for ( int i = 0; i < source.length(); i++ )
            {
                char s = source.charAt( i );
                char t = target.charAt( index );
                if ( s == t )
                {
                    index++;
                    if ( index == target.length() )
                    {

                        break;
                    }
                }
            }
            if ( index == lastindex )
            {
                return -1;
            }
        }
        return output;
    }

    public static void main( String[] args )
    {

        Test t = new Test();
        int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        //        int[][] arr = new int[][] { { 3, 5, 3 }, { 6, 17, 6 }, { 7, 13, 18 }, { 9, 10, 18 } };
        //        int[][] arr = new int[][] { { 1, 5, 3 }, { 2, 9, 4 } };
        int d = 'e';
        List< List< Integer > > list = new ArrayList<>();
        list.add( new ArrayList<>() );
        list.add( new ArrayList<>() );
        list.add( new ArrayList<>() );
        list.add( new ArrayList<>() );
        list.get( 0 ).add( 2 );
        list.get( 1 ).add( 3 );
        list.get( 1 ).add( 4 );
        list.get( 2 ).add( 6 );
        list.get( 2 ).add( 5 );
        list.get( 2 ).add( 7 );
        list.get( 3 ).add( 4 );
        list.get( 3 ).add( 1 );
        list.get( 3 ).add( 8 );
        list.get( 3 ).add( 3 );
        //        char arr[][] =
        //            new char[][] { { '0', '1' }, { '1', '0' } };
        //        System.out.println( t.shortestWay( "aaaaa",
        //            "aaaaaaaaaaaaa" ) );
        //        System.out.println( t.shortestWay( "xyz",
        //            "xzyxz" ) );
        System.out.println( t.findContentChildren( new int[] { 1, 2, 3 }, new int[] { 1, 1 } ) );
        //        list.add( "a" );
        //        list.add( "p" );
        //        list.add( "ent" );
        //        list.add( "enter" );
        //        list.add( "ot" );
        //        list.add( "o" );
        //        list.add( "t" );
        //        System.out
        //            .println(
        //                t.allConstruct( "enterapotentpot", list ) );

    }
}

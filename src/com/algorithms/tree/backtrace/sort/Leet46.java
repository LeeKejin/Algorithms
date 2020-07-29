package com.algorithms.tree.backtrace.sort;

import java.util.ArrayList;
import java.util.List;

public class Leet46
{
    static List< List< Integer > > results = new ArrayList<>();
    static List< Boolean > used = new ArrayList<>();

    public static List< List< Integer > > permute( int[] nums )
    {
        if ( nums.length == 0 ) return results;
        back( nums, new ArrayList<>() );
        return results;
    }

    private static void back( int[] nums, ArrayList< Integer > list )
    {
        if ( list.size() == nums.length )
        {
            results.add( new ArrayList<>( list ) );
            return;
        }

        for ( int i = 0; i < nums.length; i++ )
        {
            //if using list.contains( nums[ i ] ), the result is still correct, but really bad performance!!!!
            if ( used.get( i ) )
            {
                continue;
            }
            list.add( nums[ i ] );
            used.set( i, true );
            System.out.println( "Begin to back after adding " + nums[ i ] );
            back( nums, list );
            System.out.println( "After back and remove  " + list.get( list.size() - 1 ) );
            used.set( i, false );
            list.remove( list.size() - 1 );

        }
    }

    public static void main( String[] args )
    {
        int[] nums = new int[] { 1, 2, 3 };
        for ( int num : nums )
        {
            used.add( false );
        }
        permute( nums );
        System.out.println( results );
    }
}

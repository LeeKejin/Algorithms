package com.algorithms.tree.backtrace.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet47
{
    Set< List< Integer > > results = new HashSet<>();
    List< List< Integer > > res = new ArrayList<>();

    public List< List< Integer > > permuteUniqueSetSolution( int[] nums )
    {

        if ( nums.length == 0 ) return new ArrayList<>();

        back( nums, new ArrayList< Integer >(), new ArrayList< Integer >() );
        res.addAll( results );
        return res;

    }

    private void back( int[] nums, ArrayList< Integer > list, ArrayList< Integer > listOfIndex )
    {
        if ( list.size() == nums.length )
        {
            results.add( new ArrayList<>( list ) );
            return;
        }
        for ( int i = 0; i < nums.length; i++ )
        {
            if ( listOfIndex.contains( i ) ) continue;

            list.add( nums[ i ] );
            listOfIndex.add( i );
            back( nums, list, listOfIndex );
            listOfIndex.remove( listOfIndex.size() - 1 );
            list.remove( list.size() - 1 );
        }

    }

    List< Boolean > used = new ArrayList<>();

    public List< List< Integer > > permuteUnique( int[] nums )
    {
        if ( nums.length == 0 ) return new ArrayList<>();
        Arrays.sort( nums );
        for ( int i = 0; i < nums.length; i++ )
        {
            used.add( false );
        }
        backTrace( nums, new ArrayList< Integer >() );
        return res;
    }

    private void backTrace( int[] nums, ArrayList< Integer > list )
    {
        if ( list.size() == nums.length )
        {
            res.add( new ArrayList<>( list ) );
            return;
        }

        for ( int i = 0; i < nums.length; i++ )
        {
            if ( used.get( i ) ) continue;
            if ( i > 0 && nums[ i ] == nums[ i - 1 ] && used.get( i - 1 ) )
            {
                break;
            }
            list.add( nums[ i ] );
            used.set( i, true );
            backTrace( nums, list );
            used.set( i, false );
            list.remove( list.size() - 1 );
        }
    }

}

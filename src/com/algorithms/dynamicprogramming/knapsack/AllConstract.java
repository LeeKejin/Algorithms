package com.algorithms.dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstract
{
    Map< String, List< List< String > > > map = new HashMap<>();

    public List< List< String > > canConstruct( String target, String[] strs )
    {
        find( target, strs );
        if ( map.get( target ) == null ) return new ArrayList<>();
        return map.get( target );
        //        return map.get( target );
    }

    private List< List< String > > find( String target, String[] strs )
    {
        if ( target.equals( "" ) )
        {
            List< List< String > > empty = new ArrayList<>();
            List< String > innerList = new ArrayList<>();
            empty.add( innerList );
            return empty;
        }
        for ( String str : strs )
        {
            if ( target.startsWith( str ) )
            {
                String newTarget = target.substring( str.length() );
                List< List< String > > v = checkIfNewTargetHasExistedInMap( strs, newTarget );

                if ( v != null )
                {
                    List< List< String > > copyV = copySubLists( v );
                    List< List< String > > existed = map.get( target ) == null ? new ArrayList<>() : map.get( target );

                    for ( List< String > innerList : copyV )
                    {
                        innerList.add( str );
                    }
                    existed.addAll( copyV );
                    map.put( target, existed );
                }

            }
        }
        return map.get( target );
    }

    private List< List< String > > checkIfNewTargetHasExistedInMap( String[] strs, String newTarget )
    {
        if ( map.containsKey( newTarget ) )
        {
            return map.get( newTarget );
        }
        return find( newTarget, strs );
    }

    private List< List< String > > copySubLists( List< List< String > > v )
    {
        List< List< String > > copyV = new ArrayList<>();
        for ( List< String > innerList : v )
        {
            ArrayList< String > copy = new ArrayList<>( innerList );
            copyV.add( copy );
        }
        return copyV;
    }

    public List< List< String > > allConstructDP( String target, List< String > wordBank )
    {
        Map< Integer, List< List< String > > > dp = new HashMap<>();
        List< List< String > > first = new ArrayList<>();
        first.add( new ArrayList<>() );
        dp.put( 0, first );
        for ( int i = 1; i <= target.length() + 1; i++ )
        {
            dp.put( i, null );
        }

        for ( int i = 0; i < target.length(); i++ )
        {
            if ( dp.get( i ) != null )
            {
                String str = target.substring( i );
                for ( String word : wordBank )
                {
                    if ( str.startsWith( word ) )
                    {
                        int len = word.length();
                        if ( dp.get( len + i ) != null )
                        {
                            List< List< String > > existedList = dp.get( len + i );
                            List< List< String > > list = dp.get( i );
                            List< List< String > > copiedList = new ArrayList<>();
                            for ( List< String > innerList : list )
                            {
                                copiedList.add( new ArrayList<>( innerList ) );
                            }
                            for ( List< String > innerList : copiedList )
                            {
                                innerList.add( word );
                            }
                            existedList.addAll( copiedList );
                        }
                        else
                        {
                            List< List< String > > existedList = new ArrayList<>();
                            List< List< String > > list = dp.get( i );

                            List< List< String > > copiedList = new ArrayList<>();
                            for ( List< String > innerList : list )
                            {
                                copiedList.add( new ArrayList<>( innerList ) );
                            }
                            for ( List< String > innerList : copiedList )
                            {
                                innerList.add( word );
                            }
                            existedList.addAll( copiedList );

                            dp.put( len + i, existedList );
                        }

                    }
                }
            }
        }
        return dp.get( target.length() );
    }

}

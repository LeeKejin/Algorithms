package com.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class Leet131
{
    static List< List< String > > results = new ArrayList<>();

    public static List< List< String > > partition( String s )
    {
        if ( s == null && s.equals( "" ) ) return new ArrayList<>();
        /*
         * This is unnecessary, but can improve performance!!!!
         */
       /* if ( s.length() == 1 )
        {
            List< String > list = new ArrayList< String >();
            list.add( s );
            results.add( list );
            return results;
        }*/
        back( s, new ArrayList< String >(), 0 );
        return results;
    }

    public static void back( String s, List< String > list, int index )
    {
        if ( index == s.length() )
        {
            if ( !list.isEmpty() ) results.add( new ArrayList<>( list ) );
            return;
        }
        for ( int i = 1; i <= s.length(); i++ )
        {
            if ( index + i > s.length() )
            {
                return;
            }
            String segment = s.substring( index, index + i );

            if ( isPalindrome( segment ) )
            {
                list.add( segment );
            }
            else
            {
                continue;
            }

            back( s, list, index + i );
            list.remove( list.size() - 1 );
        }
    }

    public static boolean isPalindrome( String segment )
    {
        int start = 0;
        int end = segment.length() - 1;
        while ( end >= start )
        {
            if ( segment.charAt( start ) == segment.charAt( end ) )
            {
                end--;
                start++;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args )
    {
        partition( "efe" );
        System.out.println( results );
    }
}

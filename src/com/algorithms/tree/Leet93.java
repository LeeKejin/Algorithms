package com.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class Leet93
{
    static List< String > results = new ArrayList<>();

    public static List< String > restoreIpAddresses( String s )
    {
        if ( s == null || s.length() == 0 )
        {
            return results;
        }
        back( s, 0, new ArrayList< String >() );
        return results;
    }

    private static void back( String s, int index, ArrayList< String > current )
    {
        if ( current.size() == 4 )
        {
            if ( index == s.length() )
            {
                results.add( String.join( ".", current ) );
            }
            return;
        }

        for ( int i = 1; i <= 3; i++ )
        {
            if ( index + i > s.length() )
            {
                break;
            }
            String seg = s.substring( index, index + i );
            if ( ( i == 3 && Integer.parseInt( seg ) > 255 ) || ( seg.startsWith( "0" ) && seg.length() > 1 ) )
            {
                break;
            }
            current.add( seg );
            back( s, index + i, current );
            current.remove( current.size() - 1 );
        }
    }

    public static void main( String[] args )
    {
        restoreIpAddresses( "25525511135" );
        System.out.println( results );
    }
}

package com.algorithms.tree.backtrace.combination;

import java.util.ArrayList;
import java.util.List;

public class Leet401
{
    static List< String > results = new ArrayList<>();
    static List< Integer > time = new ArrayList<>();

    public static List< String > readBinaryWatch( int num )
    {
        if ( num == 0 )
        {
            results.add( "00:00" );
            return results;
        }
        for ( int i = 0; i < 10; i++ )
        {
            time.add( 0 );
        }
        back( num, 0 );
        return results;
    }

    private static void back( int num, int start )
    {
        if ( num == 0 )
        {
            int hour = time.get( 0 ) + time.get( 1 ) * 2 + time.get( 2 ) * 4 + time.get( 3 ) * 8;
            int minute = time.get( 4 ) + time.get( 5 ) * 2 + time.get( 6 ) * 4 + time.get( 7 ) * 8 + time.get( 8 ) * 16
                + time.get( 9 ) * 32;
            if ( hour < 12 && minute < 60 )
            {
                if ( minute > 10 )
                {
                    results.add( hour + ":" + minute );
                }
                else
                {
                    results.add( hour + ":0" + minute );
                }
            }
            return;
        }

        for ( int i = start; i < time.size(); i++ )
        {
            time.set( i, 1 );
            back( num - 1, i + 1 );
            time.set( i, 0 );
        }

    }
}

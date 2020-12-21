package com.algorithms.queue.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leet752
{
    Set< String > visited = new HashSet<>();
    Set< String > deadEnds = new HashSet<>();

    public int openLock( String[] deadends, String target )
    {
        Queue< String > queue = new LinkedList<>();

        queue.add( "0000" );
        visited.add( "0000" );

        for ( String deadend : deadends )
        {
            deadEnds.add( deadend );
        }
        int count = -1;
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            for ( int i = 0; i < size; i++ )
            {
                String cur = queue.poll();
                if ( deadEnds.contains( cur ) ) continue;
                if ( cur.equals( target ) ) return count + 1;
                addAdjToQueue( queue, cur );
            }
            count++;
        }
        return -1;
    }

    private void addAdjToQueue( Queue< String > queue, String cur )
    {
        for ( int i = 0; i < 4; i++ )
        {
            String po = plusOne( cur, i );
            String mo = minusOne( cur, i );
            if ( !visited.contains( po ) )
            {
                queue.add( po );
                visited.add( po );
            }
            if ( !visited.contains( mo ) )
            {
                queue.add( mo );
                visited.add( mo );
            }
        }
    }

    private String minusOne( String cur, int index )
    {
        char[] ch = cur.toCharArray();
        if ( ch[ index ] == '0' )
        {
            ch[ index ] = '9';
        }
        else
        {
            ch[ index ] -= 1;
        }
        return new String( ch );
    }

    private String plusOne( String cur, int index )
    {
        char[] ch = cur.toCharArray();
        if ( ch[ index ] == '9' )
        {
            ch[ index ] = '0';
        }
        else
        {
            ch[ index ] += 1;
        }
        return new String( ch );
    }
}

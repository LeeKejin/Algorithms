package com.amazon.interview.topologicalsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Leet269
{
    public String alienOrder( String[] words )
    {
        Map< Character, Set< Character > > map = new HashMap<>();
        //相邻的两个单词比较。
        for ( int i = 0; i < words.length - 1; i++ )
        {
            int length = Math.max( words[ i ].length(), words[ i + 1 ].length() );
            for ( int j = 0; j < length; j++ )
            {
                //如果是ab,abc这种，则继续
                if ( j >= words[ i ].length() )
                {
                    break;
                }
                //如果是abc,ab这种，则返回空
                if ( j >= words[ i + 1 ].length() )
                {
                    return "";
                }
                if ( words[ i ].charAt( j ) == words[ i + 1 ].charAt( j ) )
                {
                    continue;
                }
                map.putIfAbsent( words[ i ].charAt( j ), new HashSet<>() );
                map.get( words[ i ].charAt( j ) ).add( words[ i + 1 ].charAt( j ) );
                break;
            }
        }

        int degree[] = new int[ 26 ];
        Arrays.fill( degree, -1 );
        for ( String word : words )
        {
            for ( char c : word.toCharArray() )
            {
                degree[ c - 'a' ] = 0;
            }
        }

        for ( Character character : map.keySet() )
        {
            for ( char dep : map.get( character ) )
            {
                degree[ dep - 'a' ]++;
            }
        }
        int count = 0;
        Queue< Character > queue = new LinkedList<>();
        for ( int i = 0; i < 26; i++ )
        {
            if ( degree[ i ] != -1 )
            {
                count++;
            }
            if ( degree[ i ] == 0 )
            {
                queue.add( ( char ) ( 'a' + i ) );
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        while ( !queue.isEmpty() )
        {
            char c = queue.poll();
            stringBuilder.append( c );
            if ( map.containsKey( c ) )
            {
                Set< Character > depSet = map.get( c );
                for ( char dep : depSet )
                {
                    degree[ dep - 'a' ]--;
                    if ( degree[ dep - 'a' ] == 0 )
                    {
                        queue.add( dep );
                    }
                }
            }
        }
        return stringBuilder.length() == count ? stringBuilder.toString() : "";
    }
}

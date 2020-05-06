package com.algorithms.collection.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet49
{
    public static List< List< String > > groupAnagrams( String[] strs )
    {
        Map< String, List< String > > map = new HashMap<>();
        List< List< String > > res = new ArrayList<>();
        boolean flag = false;
        for ( String str : strs )
        {
            char[] charStr = str.toCharArray();
            Arrays.sort( charStr );
            String sortedStr = new String( charStr );
            if ( map.isEmpty() )
            {
                List< String > list = new ArrayList<>();
                list.add( str );
                map.put( sortedStr, list );
            }
            else
            {
                if ( map.containsKey( sortedStr ) )
                {
                    map.get( sortedStr ).add( str );
                }
                else
                {
                    List< String > list = new ArrayList<>();
                    list.add( str );
                    map.put( sortedStr, list );
                }
            }
        }
        for ( String key : map.keySet() )
        {
            res.add( map.get( key ) );
        }
        return res;
    }

    public static void main( String[] args )
    {
        String str[] = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        groupAnagrams( str );
    }

}

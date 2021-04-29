package com.amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet49
{
    public List< List< String > > groupAnagrams( String[] strs )
    {
        List< List< String > > res = new ArrayList<>();
        Map< String, List< String > > map = new HashMap<>();
        for ( String str : strs )
        {
            char[] chars = str.toCharArray();
            Arrays.sort( chars );
            String orderedStr = String.valueOf( chars );
            if ( map.containsKey( orderedStr ) )
            {
                map.get( orderedStr ).add( str );
            }
            else
            {
                List< String > list = new ArrayList<>();
                list.add( str );
                map.put( orderedStr, list );
            }
        }

        for ( List< String > list : map.values() )
        {
            res.add( list );
        }
        return res;
    }
}

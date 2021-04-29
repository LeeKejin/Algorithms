package com.amazon.interview.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet763
{
    public List< Integer > partitionLabels( String S )
    {
        if ( S == null ) return new ArrayList<>();
        Map< Character, Integer > map = new HashMap<>();
        int max = 0;
        for ( int i = 0; i < S.length(); i++ )
        {
            map.put( S.charAt( i ), i );
        }
        int end = 0;
        int start = 0;
        List< Integer > res = new ArrayList<>();

        for ( int i = 0; i < S.length(); i++ )
        {
            end = Math.max( end, map.get( S.charAt( i ) ) );
            if ( i == end )
            {
                res.add( end - start + 1 );
                start = end + 1;
            }
        }
        return res;
    }
}

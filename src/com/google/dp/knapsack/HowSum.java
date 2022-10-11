package com.google.dp.knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum
{
    public List< Integer > howSum( int target, int[] nums )
    {

        Map< Integer, List< Integer > > map = new HashMap<>();
        map.put( 0, new ArrayList<>() );
        for ( int j = 0; j < nums.length; j++ )
        {
            List< Integer > list = new ArrayList<>();
            list.add( nums[ j ] );
            map.put( nums[ j ], list );
        }

        for ( int i = 0; i <= target; i++ )
        {

            if ( map.get( i ) != null )
            {
                for ( int j = 0; j < nums.length; j++ )
                {
                    if ( nums[ j ] + i <= target )
                    {
                        List< Integer > list = map.get( i );
                        if ( map.containsKey( nums[ j ] + i ) ) continue;
                        List< Integer > copiedList = new ArrayList<>( list );
                        copiedList.add( nums[ j ] );
                        map.put( nums[ j ] + i, copiedList );
                        //if common out this line, for the case [8, {2,3,5}], it will return [2,2,2,2]
                        if ( map.containsKey( target ) ) return map.get( target );
                    }
                }
            }
        }

        return map.get( target );
    }
}

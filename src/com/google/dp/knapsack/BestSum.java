package com.google.dp.knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum
{
    Map< Integer, List< Integer > > map = new HashMap<>();

    public List< Integer > bestSum( int sum, int[] nums )
    {
        if ( sum == 0 ) return new ArrayList<>();
        if ( sum < 0 ) return null;
        for ( int i = 0; i < nums.length; i++ )
        {
            List< Integer > res;
            if ( map.containsKey( sum - nums[ i ] ) )
            {
                res = map.get( sum - nums[ i ] );
            }
            else
            {
                res = bestSum( sum - nums[ i ], nums );
            }

            if ( res != null )
            {
                res.add( nums[ i ] );
                if ( map.containsKey( sum ) )
                {
                    List< Integer > existedComs = map.get( sum );
                    if ( existedComs.size() > res.size() )
                    {
                        map.put( sum, res );
                    }
                }
                else
                {
                    map.put( sum, res );
                }
            }
        }
        return map.get( sum );
    }
}

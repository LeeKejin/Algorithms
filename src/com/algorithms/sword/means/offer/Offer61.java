package com.algorithms.sword.means.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer61
{
    public boolean isStraight( int[] nums )
    {
        Set< Integer > set = new HashSet<>();
        int count = 0;
        int min = 14;
        int max = -1;
        for ( int num : nums )
        {
            if ( num == 0 )
            {
                continue;
            }
            else
            {
                if ( set.contains( num ) ) return false;
                set.add( num );
                min = Math.min( min, num );
                max = Math.max( max, num );
            }

        }
        return max - min < 5;
    }
}

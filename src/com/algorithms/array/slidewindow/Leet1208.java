package com.algorithms.array.slidewindow;

public class Leet1208
{
    public int equalSubstring( String s, String t, int maxCost )
    {
        int right = 0;
        int left = 0;
        int len = 0;
        int sum = 0;
        while ( right < s.length() )
        {
            int v = Math.abs( s.charAt( right ) - t.charAt( right ) );
            sum += v;

            right++;

            if ( sum > maxCost )
            {
                if ( len < right - left - 1 )
                {
                    len = right - left - 1;
                }
                while ( sum > maxCost )
                {
                    sum -= Math.abs( s.charAt( left ) - t.charAt( left ) );
                    left++;
                }
            }
        }
        if ( right - left > len ) return right - left;
        return len;
    }
}

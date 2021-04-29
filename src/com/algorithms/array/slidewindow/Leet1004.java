package com.algorithms.array.slidewindow;

public class Leet1004
{
    public int longestOnes( int[] A, int K )
    {
        if ( A.length <= K ) return A.length;
        int right = 0;
        int left = 0;
        int valid = 0;
        int len = K;
        while ( right < A.length )
        {
            if ( A[ right ] == 0 )
            {
                valid++;
            }
            right++;

            if ( valid > K )
            {
                if ( len < right - left - 1 )
                {
                    len = right - left - 1;
                }
                while ( valid > K )
                {
                    if ( A[ left ] == 0 )
                    {
                        valid--;
                    }
                    left++;
                }
            }
        }
        if ( len < right - left ) return right - left;
        return len;
    }
}

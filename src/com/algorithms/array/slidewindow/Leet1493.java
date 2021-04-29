package com.algorithms.array.slidewindow;

public class Leet1493
{
    class Solution
    {
        public int longestSubarray( int[] nums )
        {
            int right = 0;
            int left = 0;
            int len = -1;
            int valid = 0;
            while ( right < nums.length )
            {
                if ( nums[ right ] == 0 )
                {
                    valid++;
                }
                right++;
                if ( valid > 1 )
                {
                    if ( len < right - left - 1 - 1 )
                    {
                        len = right - left - 1 - 1;
                    }
                    while ( valid > 1 )
                    {
                        if ( nums[ left ] == 0 )
                        {
                            valid--;
                        }
                        left++;
                    }
                }
            }
            if ( len == -1 ) return nums.length - 1;
            if ( right - left - 1 > len ) return right - left - 1;
            return len;
        }
    }
}

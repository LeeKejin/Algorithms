package com.algorithms.array.leetcode;
//Container With Most Water
public class Leet11
{
    public static int maxArea( int[] height )
    {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int temp = 0;
        while ( left < right )
        {

            if ( height[ left ] < height[ right ] )
            {
                temp = height[ left ] * ( right - left );
                left++;
            }
            else
            {
                temp = height[ right ] * ( right - left );
                right--;
            }
            area = Math.max( temp, area );
        }
        return area;
    }
}

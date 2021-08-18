package com.algorithms.array.leetcode;

public class Leet88
{
    public void merge3Pointers( int[] nums1, int m, int[] nums2, int n )
    {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        while ( i >= 0 )
        {
            if ( p1 < 0 )
            {
                nums1[ i ] = nums2[ p2 ];
                p2--;
            }
            else if ( p2 < 0 )
            {
                nums1[ i ] = nums1[ p1 ];
                p1--;
            }
            else if ( nums1[ p1 ] > nums2[ p2 ] )
            {
                nums1[ i ] = nums1[ p1 ];
                p1--;
            }
            else
            {
                nums1[ i ] = nums2[ p2 ];
                p2--;
            }
            i--;
        }
    }

    public void merge( int[] nums1, int m, int[] nums2, int n )
    {
        int i1 = m - 1;
        int i2 = n - 1;
        while ( i2 >= 0 )
        {
            if ( i1 < 0 )
            {
                nums1[ i2 ] = nums2[ i2 ];
                i2--;
            }
            else if ( nums2[ i2 ] >= nums1[ i1 ] )
            {
                nums1[ i1 + i2 + 1 ] = nums2[ i2 ];
                i2--;
            }
            else
            {
                nums1[ i1 + i2 + 1 ] = nums1[ i1 ];
                i1--;
            }
        }
    }

    public void mergeMethodTwo( int[] nums1, int m, int[] nums2, int n )
    {
        int i1 = m - 1;
        int i2 = n - 1;
        for ( int i = m + n - 1; i >= 0; i-- )
        {
            if ( i1 < 0 )
            {
                nums1[ i ] = nums2[ i ];
            }
            else if ( i2 >= 0 )
            {
                if ( nums1[ i1 ] > nums2[ i2 ] )
                {
                    nums1[ i ] = nums1[ i1 ];
                    i1--;
                }
                else
                {
                    nums1[ i ] = nums2[ i2 ];
                    i2--;
                }
            }
        }
    }

}

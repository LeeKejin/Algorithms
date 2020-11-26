package com.algorithms.binary.search.leetcode;

public class Leet4
{
    public double findMedianSortedArrays( int[] nums1, int[] nums2 )
    {
        int n = nums1.length;
        int m = nums2.length;
        int left = ( m + n + 1 ) / 2;
        int right = ( m + n + 2 ) / 2;
        return ( getKth( nums1, 0, nums2, 0, left ) + getKth( nums1, 0, nums2, 0, right ) ) * 0.5;
    }

    private double getKth( int[] nums1, int start1, int[] nums2, int start2, int k )
    {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if ( len1 <= 0 ) return nums2[ start2 + k - 1 ];
        if ( len1 > len2 ) return getKth( nums2, start2, nums1, start1, k );
        if ( k == 1 ) return Math.min( nums1[ start1 ], nums2[ start2 ] );
        int i = start1 + Math.min( k / 2, len1 ) - 1;
        int j = start2 + Math.min( k / 2, len2 ) - 1;

        if ( nums1[ i ] < nums2[ j ] )
        {
            return getKth( nums1, i + 1, nums2, start2, k - Math.min( k / 2, len1 ) );
        }
        return getKth( nums1, start1, nums2, j + 1, k - Math.min( k / 2, len2 ) );
    }
}

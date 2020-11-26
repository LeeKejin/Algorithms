package com.algorithms.array.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet658
{
    public List< Integer > findClosestElements( int[] arr, int k, int x )
    {
        List< Integer > res = new ArrayList<>();
        int index = findClosestElements( arr, x, k, 0, arr.length - k );
        for ( int i = 0; i < k; i++ )
        {
            res.add( arr[ i + index ] );
        }
        return res;
    }

    private int findClosestElements( int[] arr, int x, int k, int l, int r )
    {
        if ( l == r ) return l;
        int mid = l + ( r - l ) / 2;
        if ( x - arr[ mid ] > arr[ mid + k ] - x )
        {
            return findClosestElements( arr, x, k, mid + 1, r );
        }
        return findClosestElements( arr, x, k, l, mid );
    }

}

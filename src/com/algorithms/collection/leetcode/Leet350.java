package com.algorithms.collection.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet350
{
    public static int[] intersect( int[] nums1, int[] nums2 )
    {
        Map< Integer, Integer > map1 = new HashMap<>();
        Map< Integer, Integer > map2 = new HashMap<>();

        for ( int v : nums1 )
        {
            if ( map1.containsKey( v ) )
            {
                int times = map1.get( v );
                map1.put( v, ++times );
            }
            else
            {
                map1.put( v, 1 );
            }
        }

        for ( int v : nums2 )
        {
            if ( map2.containsKey( v ) )
            {
                int times = map2.get( v );
                map2.put( v, ++times );
            }
            else
            {
                map2.put( v, 1 );
            }
        }

        if ( map1.size() > map2.size() ) return compareResult( map1, map2 );
        return compareResult( map2, map1 );
    }

    private static int[] compareResult( Map< Integer, Integer > big, Map< Integer, Integer > small )
    {
        Map< Integer, Integer > map = new HashMap<>();
        for ( int key : big.keySet() )
        {
            if ( small.containsKey( key ) )
            {
                int times = small.get( key ) < big.get( key ) ? small.get( key ) : big.get( key );
                map.put( key, times );
            }
        }
        int size = 0;
        for ( int key : map.keySet() )
        {
            size += map.get( key );
        }
        int[] res = new int[ size ];
        int count = 0;
        for ( int key : map.keySet() )
        {
            for ( int i = 0; i < map.get( key ); i++ )
            {
                res[ count ] = key;
                count++;
            }

        }
        return res;
    }

    public static int[] intersectSolution1( int[] nums1, int[] nums2 )
    {
        Map< Integer, Integer > map1 = new HashMap<>();

        for ( int v : nums1 )
        {
            if ( map1.containsKey( v ) )
            {
                int times = map1.get( v );
                map1.put( v, ++times );
            }
            else
            {
                map1.put( v, 1 );
            }
        }
        Map< Integer, Integer > map = new HashMap<>();
        for ( int v : nums2 )
        {
            if ( map1.containsKey( v ) && map1.get( v ) > 0 )
            {
                if ( map.containsKey( v ) )
                {
                    int t = map.get( v );
                    map.put( v, ++t );
                }
                else
                {
                    map.put( v, 1 );
                }
                int times = map1.get( v );
                map1.put( v, --times );
            }
        }
        int size = 0;
        for ( int key : map.keySet() )
        {
            size += map.get( key );
        }
        int[] res = new int[ size ];
        int count = 0;
        for ( int key : map.keySet() )
        {
            for ( int i = 0; i < map.get( key ); i++ )
            {
                res[ count ] = key;
                count++;
            }

        }
        return res;
    }

    public static int[] intersectSolution2( int[] nums1, int[] nums2 )
    {
        Map< Integer, Integer > map1 = new HashMap<>();

        for ( int v : nums1 )
        {
            if ( map1.containsKey( v ) )
            {
                int times = map1.get( v );
                map1.put( v, ++times );
            }
            else
            {
                map1.put( v, 1 );
            }
        }
        List< Integer > list = new ArrayList<>();
        for ( int v : nums2 )
        {
            if ( map1.containsKey( v ) && map1.get( v ) > 0 )
            {
                list.add( v );
                int times = map1.get( v );
                map1.put( v, --times );
            }
        }

        int[] res = new int[ list.size() ];
        int index = 0;
        for ( int i : list )
        {
            res[ index++ ] = i;
        }
        return res;
    }

    //really slow
    public static int[] intersectSolution3( int[] nums1, int[] nums2 )
    {
        Arrays.sort( nums1 );
        Arrays.sort( nums2 );
        if ( nums1.length > nums2.length ) return compareSortedResult( nums1, nums2 );
        return compareSortedResult( nums2, nums1 );
    }

    public static int[] intersectSolution4( int[] nums1, int[] nums2 )
    {
        Arrays.sort( nums1 );
        Arrays.sort( nums2 );
        if ( nums1.length > nums2.length ) return compareSortedResultWithoutMap( nums1, nums2 );
        return compareSortedResultWithoutMap( nums2, nums1 );
    }

    private static int[] compareSortedResultWithoutMap( int[] big, int[] small )
    {
        int i = 0;
        int j = 0;
        List< Integer > list = new ArrayList<>();
        while ( i < big.length )
        {
            if ( j >= small.length ) break;
            if ( big[ i ] == small[ j ] )
            {
                list.add( small[ j ] );
                i++;
                j++;
            }
            else if ( big[ i ] < small[ j ] )
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        int[] res = new int[ list.size() ];
        int index = 0;
        for ( int v : list )
        {
            res[ index++ ] = v;
        }
        return res;
    }

    private static int[] compareSortedResult( int[] big, int[] small )
    {
        List< Integer > list = new ArrayList<>();
        Map< Integer, Integer > map = new HashMap<>();
        for ( int b : big )
        {
            if ( !map.containsKey( b ) )
            {
                map.put( b, 1 );
            }
            else
            {
                int v = map.get( b );
                v++;
                map.put( b, v );
            }
        }
        int r = big.length - 1;
        int l = 0;
        for ( int i = 0; i < small.length; i++ )
        {
            r = big.length - 1;
            while ( ( l <= r ) )
            {
                int mid = l + ( r - l ) / 2;

                if ( small[ i ] == big[ mid ] )
                {
                    int v = map.get( big[ mid ] );
                    v--;
                    map.put( big[ mid ], v );
                    if ( map.get( big[ mid ] ) >= 0 )
                        list.add( small[ i ] );

                    l = mid;

                    break;
                }
                else if ( small[ i ] > big[ mid ] )
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }

            }
        }
        int[] res = new int[ list.size() ];
        int index = 0;
        for ( int i : list )
        {
            res[ index++ ] = i;
        }
        return res;
    }

    public static void main( String[] args )
    {
        int[] arr =
            new int[] { 61, 24, 20, 58, 95, 53, 17, 32, 45, 85, 70, 20, 83, 62, 35, 89, 5, 95, 12, 86, 58, 77, 30, 64,
                46, 13, 5, 92, 67, 40, 20, 38, 31, 18, 89, 85, 7, 30, 67, 34, 62, 35, 47, 98, 3, 41, 53, 26, 66, 40, 54,
                44, 57, 46, 70, 60, 4, 63, 82, 42, 65, 59, 17, 98, 29, 72, 1, 96, 82, 66, 98, 6, 92, 31, 43, 81, 88, 60,
                10, 55, 66, 82, 0, 79, 11, 81 };
        int[] arr1 =
            new int[] { 5, 25, 4, 39, 57, 49, 93, 79, 7, 8, 49, 89, 2, 7, 73, 88, 45, 15, 34, 92, 84, 38, 85, 34, 16, 6,
                99, 0, 2, 36, 68, 52, 73, 50, 77, 44, 61, 48 };

        //        int[] arr = new int[] { 5, 4, 57, 79, 7, 89, 88, 45, 34, 92, 38, 85, 6, 0, 77, 44, 61 };
        //        System.out.print( arr.length + "" );
        //        Arrays.sort( arr );

        //        System.out.println(
        //            intersectSolution3( new int[] { 4, 5, 3, 6, 1, 8, 9, 11, 12, 17 }, new int[] { 6, 6, 4, 4, 1, 1, 2, 2 } ) );
        System.out.println(
            intersectSolution3( new int[] { 3, 1, 2 }, new int[] { 1, 1 } ) );
    }
}
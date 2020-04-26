package com.algorithms.array.leetcode;

public class Leet167
{
    public static int[] twoSum( int[] numbers, int target )
    {
        int right = numbers.length - 1;
        //        int[] results = new int[ 2 ];

        for ( int i = 0; i < numbers.length; i++ )
        {

            int value = binarySearch( i + 1, right, numbers, target - numbers[ i ] );
            if ( value != -1 )
            {
                return new int[] { i + 1, value + 1 };
            }
        }
        return new int[] { -1, -1 };

    }

    private static int binarySearch( int left, int right, int[] numbers, int number )
    {
        while ( left <= right )
        {
            int mid = left + ( right - left ) / 2;
            if ( numbers[ mid ] == number ) return mid;
            if ( numbers[ mid ] < number ) left = mid + 1;
            if ( numbers[ mid ] > number ) right = mid - 1;
        }
        return -1;
    }

    public static int[] twoSumOptimize( int[] numbers, int target )
    {
        int first = 0;
        int last = numbers.length - 1;

        while ( first < last )
        {
            int value = numbers[ first ] + numbers[ last ];
            if ( value == target ) return new int[] { first + 1, last + 1 };
            if ( value < target ) first++;
            if ( value > target ) last--;
        }
        return new int[] { -1, -1 };
    }

    public static void main( String[] args )
    {
        int[] test = new int[] { 5, 25, 75 };
        int[] r = twoSum( test, 100 );
        System.out.println( r + "" );
    }
}

//
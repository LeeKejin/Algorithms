package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public int canJump( int[] nums )
    {
        int right = 0;
        int end = 0;
        int step = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            right = Math.max( right, nums[ i ] + i );
            if ( i == end )
            {
                end = right;
                step++;
            }
        }
        return step;
    }

    public static void main( String[] args )
    {

        int[][] arr = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        //        int[][] arr = new int[][] { { 1, 5, 3 }, { 2, 9, 4 } };
        int d = 'e';
        List< String > list = new ArrayList<>();
        list.add( "apple" );
        list.add( "pen" );
        list.add( "applepen" );
        list.add( "pine" );
        list.add( "pineapple" );
        int k = 4;
        int n = arr.length;
        Test t = new Test();
        char[][] chs = new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' } };
        //        char[][] chs = new char[][] {
        //            { 'a' },
        //            { 'a' } };
        //
    }
}

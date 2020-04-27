package com.algorithms.array.leetcode;

public class Leet209
{
    public static int minSubArrayLen( int s, int[] nums )
    {
        for ( int n : nums )
        {
            if ( n >= s ) return 1;
        }
        int i = 0;
        int j = -1;
        int res = nums.length + 1;
        int sum = 0;

        while ( i < nums.length )
        {
            if ( j + 1 < nums.length && sum < s )
            {
                j++;
                sum += nums[ j ];
            }
            else
            {
                sum -= nums[ i ];
                i++;
            }
            if ( sum >= s )
            {
                res = Math.min( res, j - i + 1 );
            }
        }
        if ( res == nums.length + 1 ) return 0;
        return res;
    }

    public static void main( String[] args )
    {
        //        isPalindrome( "A man, a plan, a canal: Panama" );
        int a = minSubArrayLen( 15, new int[] { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 } );
        System.out.println( a + "" );

    }
}

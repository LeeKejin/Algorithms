package com.algorithms.array.slidewindow;

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

    public int minSubArrayLenSW( int target, int[] nums )
    {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = nums.length + 1;
        while ( right < nums.length )
        {
            if ( nums[ right ] == target ) return 1;
            sum += nums[ right ];

            right++;

            if ( sum >= target )
            {
                while ( sum >= target )
                {
                    sum -= nums[ left ];
                    left++;

                }
                if ( len > ( right - ( left - 1 ) ) )
                {
                    len = right - ( left - 1 );
                }
            }

        }
        return len == nums.length + 1 ? 0 : len;
    }

    public static void main( String[] args )
    {
        //        isPalindrome( "A man, a plan, a canal: Panama" );
        int a = minSubArrayLen( 15, new int[] { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 } );
        System.out.println( a + "" );

    }
}

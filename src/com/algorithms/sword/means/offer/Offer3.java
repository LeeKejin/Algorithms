package com.algorithms.sword.means.offer;

public class Offer3
{
    public int findRepeatNumber( int[] nums )
    {
        int n = nums.length;
        int i = 0;
        while ( i < n )
        {
            if ( nums[ i ] == i )
            {
                i++;
                continue;
            }
            else
            {
                if ( nums[ i ] == nums[ nums[ i ] ] )
                {
                    return nums[ i ];
                }
                else
                {
                    swap( nums, i, nums[ i ] );
                }
            }
        }
        return 0;
    }

    public void swap( int[] nums, int i, int j )
    {
        int temp = nums[ i ];
        nums[ i ] = nums[ j ];
        nums[ j ] = temp;
    }

    public static void main( String[] args )
    {
        Offer3 o = new Offer3();
        o.findRepeatNumber( new int[] { 2, 3, 1, 0, 2, 5, 3 } );
    }
}

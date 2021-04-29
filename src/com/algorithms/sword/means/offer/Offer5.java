package com.algorithms.sword.means.offer;

import java.util.Arrays;

public class Offer5
{
    public String replaceSpace( String s )
    {
        int count = 0;
        char[] arr = s.toCharArray();
        for ( char ch : arr )
        {
            if ( ch == ' ' ) count++;
        }
        int n = s.length() - 1;

        char[] newArr = Arrays.copyOf( s.toCharArray(), s.length() + count * 2 );
        int j = newArr.length - 1;
        for ( int i = n; i >= 0; i-- )
        {
            if ( arr[ i ] == ' ' )
            {
                newArr[ j - 2 ] = '%';
                newArr[ j - 1 ] = '2';
                newArr[ j ] = '0';
                j -= 3;
            }
            else
            {
                newArr[ j ] = arr[ i ];
                j--;
            }
        }
        return String.valueOf( newArr );
    }
}

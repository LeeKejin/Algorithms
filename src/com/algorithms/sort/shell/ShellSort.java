package com.algorithms.sort.shell;

public class ShellSort
{
    Integer[] shellSort( Integer[] arr )
    {
        int h = arr.length / 2;
        while ( h >= 1 )
        {
            for ( int start = 0; start < h; start++ )
            {
                for ( int i = start + h; i < arr.length; i += h )
                {
                    int temp = arr[ i ];
                    int j;
                    for ( j = i; j >= h && arr[ j - h ] > temp; j -= h )
                    {
                        arr[ j ] = arr[ j - h ];
                    }
                    arr[ j ] = temp;
                }
            }
            h /= 2;
        }
        return arr;
    }

}

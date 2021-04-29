package com.amazon.interview;

public class Leet48_high
{
    public void rotate( int[][] matrix )
    {
        if ( matrix.length == 0 || matrix.length == 1 ) return;
        int n = matrix.length;
        for ( int i = 0; i < n / 2; i++ )//i+1代表递进一层， j在这一层里遍历元素
        {
            for ( int j = i; j < n - 1 - i; j++ )//从两边往里缩，每循环一轮要排除俩元素 因为上次已经交换过了
            {
                int temp = matrix[ i ][ j ];
                matrix[ i ][ j ] = matrix[ n - j - 1 ][ i ];
                matrix[ n - j - 1 ][ i ] = matrix[ n - i - 1 ][ n - j - 1 ];
                matrix[ n - i - 1 ][ n - j - 1 ] = matrix[ j ][ n - i - 1 ];
                matrix[ j ][ n - i - 1 ] = temp;
            }
        }
    }

    public static void main( String[] args )
    {
        Leet48_high l = new Leet48_high();
        int[][] arr = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        l.rotate( arr );
    }
}

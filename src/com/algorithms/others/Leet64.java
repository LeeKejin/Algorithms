package com.algorithms.others;

public class Leet64
{
    public int sumNums( int n )
    {
        int sum = 0;
        while ( n >= 0 )
        {
            sum += n;
            n--;
        }
        return sum;
    }

    public static int sumNumsSolution1( int n )
    {
        int sum = 0;
        sum = sum( n, sum );
        return sum;
    }

    public static int sum( int n, int total )
    {

        if ( n > 0 )
        {
            int t = n - 1;
            total = n + sum( t, total );

        }
        return total;
    }

    static int res = 0;

    public static int sumNumsSolution2( int n )
    {
        boolean x = n > 0 && ( res = n + sumNumsSolution2( n - 1 ) ) >= 0;
        return res;
    }

    public int sumNumsSolution3( int n )
    {
        boolean x = n > 1 && ( n += sumNums( n - 1 ) ) >= 0;
        return n;
    }

    public static void main( String[] args )
    {
        int sum = sumNumsSolution2( 2 );
        System.out.println( sum );
    }
}

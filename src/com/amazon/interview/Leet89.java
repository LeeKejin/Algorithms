package com.amazon.interview;

import java.util.ArrayList;
import java.util.List;

public class Leet89
{
    public List< Integer > grayCode( int n )
    {
        List< Integer > res = new ArrayList<>();
        res.add( 0 );
        int head = 1;
        for ( int i = 0; i < n; i++ )
        {
            for ( int j = res.size() - 1; j >= 0; j-- )
            {
                int val = head + res.get( j );
                res.add( val );
            }
            head <<= 1; //1,2,4,8,16,32...->  head = head * 2; move left
        }
        return res;
    }
}

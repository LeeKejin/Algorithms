package com.amazon.interview.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leet759
{
    class Interval
    {
        public int start;
        public int end;

        public Interval()
        {
        }

        public Interval( int _start, int _end )
        {
            start = _start;
            end = _end;
        }
    }

    public List< Interval > employeeFreeTime( List< List< Interval > > schedule )
    {
        List< Interval > flat = new ArrayList<>();
        for ( List< Interval > innerList : schedule )
        {
            for ( Interval interval : innerList )
            {
                flat.add( interval );
            }
        }

        Collections.sort( flat, new Comparator< Interval >()
        {
            @Override
            public int compare( Interval o1, Interval o2 )
            {
                return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
            }
        } );
        List< Interval > res = new ArrayList<>();
        res.add( flat.get( 0 ) );

        for ( int i = 1; i < flat.size(); i++ )
        {
            if ( flat.get( i ).start <= res.get( res.size() - 1 ).end )
            {
                Interval interval = new Interval( Math.min( res.get( res.size() - 1 ).start, flat.get( i ).start ),
                    Math.max( flat.get( i ).end, res.get( res.size() - 1 ).end ) );
                res.remove( res.size() - 1 );
                res.add( interval );
            }
            else
            {
                res.add( flat.get( i ) );
            }
        }
        List< Interval > values = new ArrayList<>();
        for ( int i = 1; i < res.size(); i++ )
        {
            Interval interval = new Interval( res.get( i - 1 ).end, res.get( i ).start );
            values.add( interval );
        }
        return values;
    }

}

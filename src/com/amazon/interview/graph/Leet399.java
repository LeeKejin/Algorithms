package com.amazon.interview.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet399
{
    class UnionClass
    {
        int[] parent;
        double[] weight;

        public UnionClass( int n )
        {
            parent = new int[ n ];
            weight = new double[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parent[ i ] = i;
                weight[ i ] = 1.0;
            }
        }

        void merge( int x, int y, double value )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parent[ rootX ] = rootY;
                weight[ rootY ] = weight[ x ] * value / weight[ y ];
            }
        }

        private int find( int x )
        {
            if ( x != parent[ x ] )
            {
                int origin = parent[ x ];
                parent[ x ] = find( origin );
                weight[ x ] *= weight[ origin ];
            }
            return parent[ x ];
        }

        double isConnected( int x, int y )
        {
            if ( find( x ) == find( y ) )
            {

                return weight[ x ] / weight[ y ];
            }
            return -1.0;
        }
    }

    public double[] calcEquation( List< List< String > > equations, double[] values,
        List< List< String > > queries )
    {
        UnionClass unionClass = new UnionClass( equations.size() * 2 );
        double res[] = new double[ queries.size() ];
        Map< String, Integer > indexMap = new HashMap<>();
        int index = 0;
        for ( int i = 0; i < equations.size(); i++ )
        {
            List< String > equation = equations.get( i );
            String x = equation.get( 0 );
            String y = equation.get( 1 );
            if ( !indexMap.containsKey( x ) )
            {
                indexMap.put( x, index );
                index++;
            }
            if ( !indexMap.containsKey( y ) )
            {

                indexMap.put( y, index );
                index++;
            }
            unionClass.merge( indexMap.get( x ), indexMap.get( y ), values[ i ] );
        }

        for ( int i = 0; i < queries.size(); i++ )
        {
            List< String > query = queries.get( i );
            String x = query.get( 0 );
            String y = query.get( 1 );
            if ( indexMap.containsKey( x ) && indexMap.containsKey( y ) )
            {
                res[ i ] = unionClass.isConnected( indexMap.get( x ), indexMap.get( y ) );
            }
            else
            {
                res[ i ] = -1.0;
            }
        }
        return res;
    }
}

package com.amazon.interview.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet737
{
    class UnionClass
    {
        Map< String, String > map = new HashMap<>();

        void add( String x )
        {
            if ( !map.containsKey( x ) )
            {
                map.put( x, null );
            }
        }

        void merge( String x, String y )
        {
            String rootX = find( x );
            String rootY = find( y );

            if ( !rootX.equals( rootY ) )
            {
                map.put( rootX, rootY );
            }
        }

        private String find( String x )
        {
            String root = x;
            while ( map.get( root ) != null )
            {
                root = map.get( root );
            }

            while ( !root.equals( x ) )
            {
                String org = map.get( x );
                map.put( x, root );
                x = org;
            }
            return root;
        }

        boolean isConnected( String x, String y )
        {
            return find( x ).equals( find( y ) );
        }

    }

    public boolean areSentencesSimilarTwo( String[] words1, String[] words2, List< List< String > > pairs )
    {
        if ( words1.length != words2.length ) return false;
        if ( pairs.isEmpty() )
        {
            Arrays.sort( words1 );
            Arrays.sort( words2 );
            for ( int i = 0; i < words1.length; i++ )
            {
                if ( !words1.equals( words2 ) ) return false;
            }
            return true;
        }
        UnionClass unionClass = new UnionClass();
        for ( List< String > pair : pairs )
        {
            unionClass.add( pair.get( 0 ) );
            unionClass.add( pair.get( 1 ) );
            unionClass.merge( pair.get( 0 ), pair.get( 1 ) );
        }

        for ( int i = 0; i < words1.length; i++ )
        {
            if ( words1[ i ].equals( words2[ i ] ) ) continue;
            if ( !unionClass.map.containsKey( words1[ i ] ) || !unionClass.map.containsKey( words2[ i ] ) )
                return false;
            if ( !unionClass.isConnected( words1[ i ], words2[ i ] ) ) return false;
        }
        return true;
    }

}

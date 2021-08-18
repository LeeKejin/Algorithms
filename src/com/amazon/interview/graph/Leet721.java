package com.amazon.interview.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leet721
{
    class UnionClass
    {
        int[] parents;

        public UnionClass( int n )
        {
            parents = new int[ n ];
            for ( int i = 0; i < n; i++ )
            {
                parents[ i ] = i;
            }
        }

        void merge( int x, int y )
        {
            int rootX = find( x );
            int rootY = find( y );
            if ( rootX != rootY )
            {
                parents[ rootX ] = rootY;
            }
        }

        private int find( int x )
        {
            if ( parents[ x ] != x )
            {
                parents[ x ] = find( parents[ x ] );
            }
            return parents[ x ];
        }
    }

    public List< List< String > > accountsMerge( List< List< String > > accounts )
    {
        UnionClass unionClass = new UnionClass( accounts.size() );
        Map< String, List< Integer > > emailIndexMap = new HashMap<>();
        Map< Integer, String > indexNameMap = new HashMap<>();
        for ( int j = 0; j < accounts.size(); j++ )
        {
            List< String > account = accounts.get( j );
            String name = account.get( 0 );
            indexNameMap.put( j, name );
            for ( int i = 1; i < account.size(); i++ )
            {
                if ( emailIndexMap.containsKey( account.get( i ) ) )
                {
                    emailIndexMap.get( account.get( i ) ).add( j );
                }
                else
                {
                    List< Integer > list = new ArrayList<>();
                    list.add( j );
                    emailIndexMap.put( account.get( i ), list );
                }

            }
        }
        for ( String s : emailIndexMap.keySet() )
        {
            if ( emailIndexMap.get( s ).size() > 1 )
            {
                for ( int i = 1; i < emailIndexMap.get( s ).size(); i++ )
                {
                    unionClass.merge( emailIndexMap.get( s ).get( i ), emailIndexMap.get( s ).get( i - 1 ) );
                }
            }
        }

        Map< Integer, Set< String > > map = new HashMap<>();
        for ( int i = 0; i < unionClass.parents.length; i++ )
        {
            int val = unionClass.find( unionClass.parents[ i ] );
            if ( map.containsKey( val ) )
            {
                accounts.get( i ).remove( 0 );
                map.get( val ).addAll( accounts.get( i ) );
            }
            else
            {
                Set< String > innerSet = new HashSet<>();
                accounts.get( i ).remove( 0 );
                innerSet.addAll( accounts.get( i ) );
                map.put( val, innerSet );
            }
        }
        List< List< String > > res = new ArrayList<>();
        for ( int i : map.keySet() )
        {
            String name = indexNameMap.get( i );
            List< String > list = new ArrayList<>();
            list.add( name );
            list.addAll( map.get( i ) );
            Collections.sort( list );
            res.add( list );

        }
        System.out.println( res.size() );
        return res;
    }
}

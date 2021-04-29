package com.amazon.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Leet341
public class NestedIterator implements Iterator< Integer >
{
    List< Integer > list = new ArrayList<>();
    ListIterator< Integer > it;

    public NestedIterator( List< NestedInteger > nestedList )
    {
        dfs( nestedList );
        it = list.listIterator();
    }

    private void dfs( List< NestedInteger > nestedList )
    {
        for ( NestedInteger nestedInteger : nestedList )
        {
            if ( nestedInteger.isInteger() )
            {
                list.add( nestedInteger.getInteger() );
            }
            else
            {
                dfs( nestedInteger.getList() );
            }
        }
    }

    @Override
    public Integer next()
    {
        return it.next();
    }

    @Override
    public boolean hasNext()
    {
        return it.hasNext();
    }

    public interface NestedInteger
    {
        public boolean isInteger();

        public Integer getInteger();

        public List< NestedInteger > getList();
    }
}


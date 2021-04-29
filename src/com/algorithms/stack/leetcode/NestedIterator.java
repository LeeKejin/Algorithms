package com.algorithms.stack.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator< Integer >
{
    Queue< Integer > queue = new LinkedList<>();

    public interface NestedInteger
    {
        public boolean isInteger();

        public Integer getInteger();

        public List< NestedInteger > getList();
    }

    public NestedIterator( List< NestedInteger > nestedList )
    {
        addToQueue( nestedList );
    }

    private void addToQueue( List< NestedInteger > nestedList )
    {
        if ( nestedList.isEmpty() ) return;
        for ( NestedInteger value : nestedList )
        {
            if ( value.isInteger() )
            {
                queue.add( value.getInteger() );
            }
            else
            {
                addToQueue( value.getList() );
            }
        }
    }

    @Override
    public Integer next()
    {
        return queue.poll();
    }

    @Override
    public boolean hasNext()
    {
        return !queue.isEmpty();
    }
}

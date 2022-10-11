package com.google.design;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peekVal = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasNext()) return null;
        if (peekVal == null) {
            peekVal = iterator.next();
        }
        return peekVal;
    }

    //set peekVal to null everytime when calling next()
    @Override
    public Integer next() {
        //when peeking, the value is already popped up, so no need to pop again here, if pop again, a value will be missed
        if (peekVal != null) {
            Integer val = peekVal;
            peekVal = null;
            return val;
        }
        if (!hasNext()) return null;

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return peekVal != null || iterator.hasNext();
    }
}
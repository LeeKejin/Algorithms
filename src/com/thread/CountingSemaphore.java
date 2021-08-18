package com.thread;

public class CountingSemaphore
{
    int userPermits;
    int count;

    public CountingSemaphore( int count, int initialPermits )
    {
        this.count = count;
        this.userPermits = this.count - initialPermits;
    }

    public synchronized void acquire() throws InterruptedException
    {
        while ( userPermits == count )
        {
            wait();
        }
        userPermits++;
        notify();

    }

    public synchronized void release() throws InterruptedException
    {
        while ( userPermits == 0 )
        {
            wait();
        }
        userPermits--;
        notify();
    }
}

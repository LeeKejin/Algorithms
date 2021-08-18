package com.thread;

public class BlockingQueue< T >
{
    T[] array;
    int head = 0;
    int tail = 0;
    int capacity = 0;
    int size = 0;
    CountingSemaphore lock = new CountingSemaphore( 1, 1 );
    CountingSemaphore proLock;
    CountingSemaphore conLock;

    public BlockingQueue( int capacity )
    {
        this.capacity = capacity;
        array = ( T[] ) new Object[ capacity ];
        proLock = new CountingSemaphore( capacity, capacity );
        conLock = new CountingSemaphore( capacity, 0 );
    }

    public void enqueue( T t ) throws InterruptedException
    {
        proLock.acquire();
        lock.acquire();

        if ( tail == capacity ) tail = 0;
        array[ tail ] = t;
        tail++;
        size++;

        lock.release();
        conLock.release();
    }

    public T dequeue() throws InterruptedException
    {
        conLock.acquire();
        lock.acquire();
        if ( head == capacity ) head = 0;
        T t = array[ head ];
        array[ head ] = null;
        head++;
        size--;
        lock.release();
        proLock.release();
        return t;
    }

    public static void main( String[] args ) throws InterruptedException
    {
        final BlockingQueue< Integer > q = new BlockingQueue< Integer >( 5 );

        Thread t1 = new Thread( new Runnable()
        {

            public void run()
            {
                try
                {
                    for ( int i = 0; i < 20; i++ )
                    {
                        q.enqueue( new Integer( i ) );
                        System.out.println( "enqueued " + i );
                    }
                }
                catch ( InterruptedException ie )
                {

                }
            }
        } );

        Thread t2 = new Thread( new Runnable()
        {

            public void run()
            {
                try
                {
                    for ( int i = 0; i < 10; i++ )
                    {
                        System.out.println( "Thread 2 dequeued: " + q.dequeue() );
                    }
                }
                catch ( InterruptedException ie )
                {

                }
            }
        } );

        Thread t3 = new Thread( new Runnable()
        {

            public void run()
            {
                try
                {
                    for ( int i = 0; i < 10; i++ )
                    {
                        System.out.println( "Thread 3 dequeued: " + q.dequeue() );
                    }
                }
                catch ( InterruptedException ie )
                {

                }
            }
        } );

        t1.start();
        Thread.sleep( 4000 );
        t2.start();
        t2.join();

        t3.start();
        t1.join();
        t3.join();

    }
}

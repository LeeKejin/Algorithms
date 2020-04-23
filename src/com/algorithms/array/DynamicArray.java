package com.algorithms.array;

public class DynamicArray
{
    private int[] data;
    private int size;

    public DynamicArray( int capacity )
    {
        data = new int[ capacity ];
        size = 0;
    }

    public DynamicArray()
    {
        this( 10 );
    }

    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return data.length;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int get( int index )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        return data[ index ];
    }

    public void set( int index, int value )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        data[ index ] = value;
    }

    public boolean contains( int value )
    {
        for ( int v : data )
        {
            if ( v == value ) return true;
        }
        return false;
    }

    public int find( int value )
    {
        for ( int i = 0; i < size; i++ )
        {
            if ( data[ i ] == value ) return i;
        }
        return -1;
    }

    public void removeElement( int value )
    {
        int index = find( value );
        if ( index == -1 ) return;
        remove( index );
    }

    public int remove( int index )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        int result = data[ index ];
        for ( int i = index; i < size; i++ )
        {
            data[ i ] = data[ i + 1 ];
        }
        size--;
        return result;
    }

    public int removeFirst()
    {
        return remove( 0 );
    }

    public int removeLast()
    {
        return remove( size - 1 );
    }

    public void addFirst( int value )
    {
        add( 0, value );
    }

    public void addLast( int value )
    {
        add( size, value );
    }

    public void add( int index, int value )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        for ( int i = size - 1; i >= index; i-- )
        {
            data[ i + 1 ] = data[ i ];
        }
        data[ index ] = value;
        size++;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( String.format( "Size: %d, Capacity: %d \n", size, getCapacity() ) );
        builder.append( "[" );
        for ( int value : data )
        {
            builder.append( value + " " );
        }
        builder.append( "]" );
        return builder.toString();
    }
}

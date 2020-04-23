package com.algorithms.array;

public class DynamicArray< E >
{
    private E[] data;
    private int size;

    public DynamicArray( int capacity )
    {
        data = ( E[] ) new Object[ capacity ];
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

    public E get( int index )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        return data[ index ];
    }

    public void set( int index, E value )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        data[ index ] = value;
    }

    public boolean contains( E value )
    {
        for ( E e : data )
        {
            if ( e.equals( value ) ) return true;
        }
        return false;
    }

    public int find( E value )
    {
        for ( int i = 0; i < size; i++ )
        {
            if ( data[ i ].equals( value ) ) return i;
        }
        return -1;
    }

    public void removeElement( E value )
    {
        int index = find( value );
        if ( index == -1 ) return;
        remove( index );
    }

    public E remove( int index )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        E result = data[ index ];
        for ( int i = index + 1; i < size; i++ )
        {
            data[ i - 1 ] = data[ i ];
        }
        size--;
        data[ size ] = null;
        if ( size == data.length / 2 ) resize( data.length / 2 );
        return result;
    }

    public E removeFirst()
    {
        return remove( 0 );
    }

    public E removeLast()
    {
        return remove( size - 1 );
    }

    public void addFirst( E value )
    {
        add( 0, value );
    }

    public void addLast( E value )
    {
        add( size, value );
    }

    public void add( int index, E value )
    {
        if ( index < 0 || index > size ) throw new RuntimeException( "Invalid value" );
        if ( size == data.length )
        {
            resize( 2 * size );
        }
        for ( int i = size - 1; i >= index; i-- )
        {
            data[ i + 1 ] = data[ i ];
        }
        data[ index ] = value;
        size++;
    }

    private void resize( int newCapacity )
    {
        E[] newData = ( E[] ) new Object[ newCapacity ];
        for ( int i = 0; i < size; i++ )
        {
            newData[ i ] = data[ i ];
        }

        data = newData;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( String.format( "Size: %d, Capacity: %d \n", size, getCapacity() ) );
        builder.append( "[" );
        for ( E value : data )
        {
            builder.append( value + " " );
        }
        builder.append( "]" );
        return builder.toString();
    }
}

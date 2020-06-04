package com.algorithms.sword.means.offer;

public class Leet5
{
    public static String replaceSpace( String s )
    {
        if ( s.length() == 0 || s.equals( "" ) ) return s;
        int count = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( Character.compare( s.charAt( i ), ' ' ) == 0 )
            {
                count++;
            }
        }
        int length = count * 2 + s.length();
        char[] chars = new char[ length ];
        char p1 = s.charAt( s.length() - 1 );
        char p2 = chars[ length - 1 ];
        int j = s.length() - 1;
        for ( int i = length - 1; i >= 0 && j >= 0; )
        {
            if ( Character.compare( s.charAt( j ), ' ' ) != 0 )
            {
                chars[ i ] = s.charAt( j );
                j--;
                i--;
            }
            else
            {
                chars[ i ] = '0';
                i--;
                chars[ i ] = '2';
                i--;
                chars[ i ] = '%';
                i--;
                j--;
            }
        }
        return String.valueOf( chars );
    }

    public static void main( String[] args )
    {
        System.out.println( replaceSpace( "We are happy." ) );
    }
}

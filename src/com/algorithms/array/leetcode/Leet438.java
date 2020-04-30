package com.algorithms.array.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet438
{
    public static List< Integer > findAnagrams( String s, String p )
    {
        int left = 0;
        int right = 0;
        List< Integer > res = new ArrayList<>();
        int[] freq = new int[ 265 ];
        char[] chars = s.toCharArray();

        while ( right < s.length() )
        {

            if ( right < s.length() && isExists( p, s, right ) && freq[ s.charAt( right ) ] == 0 )
            {
                freq[ s.charAt( right ) ]++;

            }
            else if ( freq[ s.charAt( right ) ] != 0 && isExists( p, s, right ) )
            {
                freq[ s.charAt( left ) ] = 0;
                freq[ s.charAt( right ) ]++;
                left++;
            }

            if ( isFindString( p, freq ) )
            {

                freq[ s.charAt( left ) ] = 0;

                if ( !res.contains( left ) ) res.add( left );
                left++;

            }

            if ( !isExists( p, s, right ) )
            {
                for ( char c : p.toCharArray() )
                {
                    freq[ c ] = 0;

                }
                left = right + 1;
            }
            right++;

        }
        return res;
    }

    public static boolean isFindString( String p, int[] freq )
    {
        for ( char c : p.toCharArray() )
        {
            if ( freq[ c ] != 1 ) return false;
        }
        return true;
    }

    public static boolean isExists( String p, String s, int right )
    {
        int i = p.indexOf( s.charAt( right ) );
        return i == -1 ? false : true;
    }

    public static List< Integer > findAnagramsSolution3( String s, String p )
    {
        int l = 0;
        int r = 0;
        int count = p.length();
        int[] freq = new int[ 256 ];
        List< Integer > res = new ArrayList< Integer >();
        for ( char ch : p.toCharArray() )
        {
            freq[ ch ]++;
        }
        while ( r < s.length() )
        {
            if ( freq[ s.charAt( r ) ] > 0 )
            {
                count--;
                freq[ s.charAt( r ) ]--;
                r++;
            }
            else
            {
                freq[ s.charAt( l ) ]++;
                l++;
                count++;
            }
            if ( count == 0 ) res.add( l );

        }
        return res;
    }

    public static List< Integer > findAnagrams1( String s, String p )
    {
        List< Integer > res = new ArrayList< Integer >();

        if ( s == null || s.length() == 0 || p == null || p.length() == 0 )
            return res;

        int l = 0, r = 0;
        int count = p.length();

        int[] hash = new int[ 256 ];

        for ( char c : p.toCharArray() )
        {
            hash[ c ]++;
        }

        while ( r < s.length() )
        {
            System.out.println( "count--111:" + count );
            System.out.println( " s.charAt( r ):" + s.charAt( r ) );
            int v = hash[ s.charAt( r ) ]--;
            System.out.println( "v:" + v );
            r++;
            System.out.println( "r:" + r );
            if ( v > 0 )
            {
                count--;
                System.out.println( " count--:" + count );
            }

            if ( count == 0 )
            {
                res.add( l );

            }

            if ( r - l == p.length() )
            {
                System.out.println( "before l:" + l );
                char ch = s.charAt( l );
                int k = hash[ s.charAt( l ) ]++;
                System.out.println( "ch:" + ch );
                l++;
                System.out.println( "After l:" + l );
                System.out.println( "K:" + k );
                if ( k >= 0 )
                {
                    System.out.println( "ch with k:" + ch );
                    count++;
                    System.out.println( "count-222:" + count );

                }

            }
        }
        return res;
    }

    public static List< Integer > findAnagramsSolution2( String s, String p )
    {
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[ 256 ];
        List< Integer > pos = new ArrayList< Integer >();

        for ( int i = 0; i < pLen; i++ )
        {
            hash[ ( int ) p.charAt( i ) ]++;
        }
        int count = 0;

        while ( right < sLen )
        {
            if ( hash[ ( int ) s.charAt( right ) ] > 0 )
            {
                System.out.println();
                System.out.println(
                    "hash[ ( int ) s.charAt( right ) ]:" + s.charAt( right ) + "-->" + hash[ ( int ) s
                        .charAt( right ) ] );
                hash[ ( int ) s.charAt( right ) ]--;
                System.out.println(
                    "hash[ ( int ) s.charAt( right ) ]:" + s.charAt( right ) + "-->" + hash[ ( int ) s
                        .charAt( right ) ] );

                count++;
                right++;
                System.out.println( "R:" + right );
                System.out.println();
                System.out.println();

            }
            else
            {
                System.out.println( "**************************" );
                System.out.println( "s.charAt( l ):" + s.charAt( left ) + "-->" + hash[ s.charAt( left ) ] );
                hash[ s.charAt( left ) ]++;
                System.out.println( "s.charAt( l ):" + s.charAt( left ) + "-->" + hash[ s.charAt( left ) ] );

                count--;
                left++;
                System.out.println( "L:" + left );
                System.out.println( "**************************" );
            }

            if ( count == pLen )
            {
                pos.add( left );
            }

        }
        return pos;
    }

    public static void main( String[] args )
    {
        //        isPalindrome( "A man, a plan, a canal: Panama" );
        findAnagramsSolution2( "cbaebabacd", "abc" );

    }

}

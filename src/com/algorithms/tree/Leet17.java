package com.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class Leet17
{
    static List< String > results = new ArrayList<>();
    static List< String > list = new ArrayList<>();

    static
    {
        list.add( "" );
        list.add( "" );
        list.add( "abc" );
        list.add( "def" );
        list.add( "ghi" );
        list.add( "jkl" );
        list.add( "mno" );
        list.add( "pqrs" );
        list.add( "tuv" );
        list.add( "wxyz" );
    }

    public static List< String > letterCombinations( String digits )
    {
        composeResults( digits, 0, "" );
        return results;
    }

    private static void composeResults( String digits, int index, String word )
    {

        if ( digits == null || digits.equals( "" ) ) return;
        if ( index == digits.length() )
        {
            results.add( word );
            return;
        }
        String letters = list.get( digits.charAt( index ) - '0' );
        for ( int i = 0; i < letters.length(); i++ )
        {
            composeResults( digits, index + 1, word + letters.charAt( i ) );
        }
    }

    public static void main( String[] args )
    {
        letterCombinations( "23" );
    }
}




















/*
if ( index == digits.length() )
        {
            results.add( word );
            return;
        }
        if ( digits.charAt( index ) == '0' || digits.charAt( index ) == '1' ) return;

        String letters = list.get( digits.charAt( index ) - '0' );
        for ( int i = 0; i < letters.length(); i++ )
        {
            composeResults( digits, index + 1, word + letters.charAt( i ) );
        }
 */
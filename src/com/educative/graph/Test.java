package com.educative.graph;

import java.util.ArrayList;

public class Test
{
    int count = 0;

    public static void main( String[] args )
    {
        String keys[] = { "the", "a", "there", "answer", "any",
            "by", "bye", "their", "abc" };
        Trie trie = new Trie();
        for ( String key : keys )
        {
            trie.insert( key );
        }
        Test test = new Test();
        System.out.println( findWords( trie.getRoot() ) );
    }

    public static void getWords( TrieNode root, ArrayList< String > result, int level, char[] str )
    {
        if ( root.isEndWord )
        {
            String temp = "";
            for ( int i = 0; i < level; i++ )
            {
                temp += String.valueOf( str[ i ] );
            }
            result.add( temp );
        }
        for ( int i = 0; i < root.children.length; i++ )
        {
            if ( root.children[ i ] != null )
            {
                char word = ( char ) ( i + 'a' );
                str[ level ] = word;
                getWords( root.children[ i ], result, level + 1, str );
            }
        }
    }

    public static ArrayList< String > findWords( TrieNode root )
    {
        ArrayList< String > result = new ArrayList< String >();
        if ( root == null ) return result;
        char[] arr = new char[ 22 ];
        getWords( root, result, 0, arr );
        return result;
    }

}

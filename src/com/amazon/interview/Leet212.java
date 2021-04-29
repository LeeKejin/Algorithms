package com.amazon.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet212
{
    class TrieNode
    {
        Map< Character, TrieNode > children;
        String word;

        public TrieNode()
        {
            children = new HashMap<>();
        }
    }

    List< String > res = new ArrayList<>();

    public List< String > findWords( char[][] board, String[] words )
    {
        TrieNode root = new TrieNode();
        if ( words.length == 0 || board.length == 0 ) return new ArrayList<>();
        for ( String word : words )
        {
            TrieNode node = root;

            for ( char ch : word.toCharArray() )
            {
                if ( !node.children.containsKey( ch ) )
                {
                    node.children.put( ch, new TrieNode() );
                }
                node = node.children.get( ch );
            }
            node.word = word;
        }

        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[ 0 ].length; j++ )
            {
                if ( root.children.containsKey( board[ i ][ j ] ) )
                {
                    dfs( board, i, j, root );
                }
            }
        }
        return res;
    }

    private void dfs( char[][] board, int i, int j, TrieNode node )
    {
        if ( i < 0 || i >= board.length || j < 0 || j >= board[ 0 ].length
            || !node.children.containsKey( board[ i ][ j ] ) )
        {
            return;
        }

        if ( node.children.get( board[ i ][ j ] ).word != null )
        {
            String val = node.children.get( board[ i ][ j ] ).word;
            res.add( val );
            node.children.get( board[ i ][ j ] ).word = null;
        }

        char ch = board[ i ][ j ];
        board[ i ][ j ] = '#';
        dfs( board, i - 1, j, node.children.get( ch ) );
        dfs( board, i + 1, j, node.children.get( ch ) );
        dfs( board, i, j - 1, node.children.get( ch ) );
        dfs( board, i, j + 1, node.children.get( ch ) );
        board[ i ][ j ] = ch;
    }
}

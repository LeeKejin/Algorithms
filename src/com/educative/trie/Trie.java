package com.educative.trie;

public class Trie
{
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            isEnd = false;
            children = new TrieNode[ 26 ];
        }
    }

    TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    int getIndex( char t )
    {
        return t - 'a';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert( String word )
    {
        if ( word == null ) return;
        word = word.toLowerCase();

        TrieNode node = root;
        int index = 0;
        for ( int i = 0; i < word.length(); i++ )
        {
            index = getIndex( word.charAt( i ) );
            if ( node.children[ index ] == null )
            {
                node.children[ index ] = new TrieNode();
            }
            node = node.children[ index ];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search( String word )
    {
        TrieNode node = getPrefixNode( word );
        return node != null && node.isEnd;
    }

    private TrieNode getPrefixNode( String word )
    {
        if ( word == null ) return null;
        int index = 0;
        word = word.toLowerCase();

        TrieNode node = root;
        for ( int i = 0; i < word.length(); i++ )
        {
            index = getIndex( word.charAt( i ) );

            if ( node.children[ index ] == null )
            {
                return null;
            }
            node = node.children[ index ];
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith( String prefix )
    {
        return getPrefixNode( prefix ) != null;
    }
}

package com.amazon.interview;

class Trie
{

    /**
     * Initialize your data structure here.
     */
    class TrieNode
    {
        private TrieNode[] link;
        private int R = 26;
        private boolean isEnd;

        public TrieNode()
        {
            link = new TrieNode[ R ];
        }

        public boolean containsKey( char ch )
        {
            return link[ ch - 'a' ] != null;
        }

        public TrieNode get( char ch )
        {
            return link[ ch - 'a' ];
        }

        public void put( char ch, TrieNode node )
        {
            link[ ch - 'a' ] = node;
        }

        public void setEnd()
        {
            isEnd = true;
        }

        protected boolean isEnd()
        {
            return isEnd;
        }
    }

    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert( String word )
    {
        TrieNode node = root;
        for ( char ch : word.toCharArray() )
        {
            if ( !node.containsKey( ch ) )
            {
                node.put( ch, new TrieNode() );
            }
            node = node.get( ch );
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search( String word )
    {
        TrieNode node = searchPrefix( word );
        return node != null && node.isEnd;
    }

    private TrieNode searchPrefix( String word )
    {
        TrieNode node = root;
        for ( int i = 0; i < word.length(); i++ )
        {
            char curLetter = word.charAt( i );
            if ( node.containsKey( curLetter ) )
            {
                node = node.get( curLetter );
            }
            else
            {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith( String prefix )
    {
        TrieNode node = searchPrefix( prefix );
        return node != null;
    }

}

package com.algorithms.stack.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet133
{
    static class Node
    {
        public int val;
        public List< Node > neighbors;

        public Node()
        {
            val = 0;
            neighbors = new ArrayList< Node >();
        }

        public Node( int _val )
        {
            val = _val;
            neighbors = new ArrayList< Node >();
        }

        public Node( int _val, ArrayList< Node > _neighbors )
        {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map< Node, Node > visited = new HashMap<>();

    public Node cloneGraph( Node node )
    {
        if ( node == null ) return null;
        if ( node.neighbors.size() == 0 )
        {
            Node copiedNode = new Node( node.val );
            return copiedNode;
        }

        return dfs( node );
    }

    private Node dfs( Node node )
    {
        if ( visited.containsKey( node ) )
        {
            return visited.get( node );
        }
        Node clonedNode = new Node( node.val, new ArrayList<>() );
        visited.put( node, clonedNode );
        for ( Node neighbor : node.neighbors )
        {
            clonedNode.neighbors.add( dfs( neighbor ) );
        }
        return clonedNode;
    }
}

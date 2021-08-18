package com.educative.graph;

public class BFS
{
    public String bfs( Graph g )
    {
        if ( g.vertices <= 0 ) return "";
        String result = "";
        boolean visited[] = new boolean[ g.vertices ];
        for ( int i = 0; i < g.vertices; i++ )
        {
            if ( !visited[ i ] )
            {
                result += bfsVisited( g, i, visited );
            }
        }
        return result;
    }

    private String bfsVisited( Graph g, int source, boolean[] visited )
    {
        Queue< Integer > queue = new Queue<>( g.vertices );
        queue.enqueue( source );
        String result = "";
        while ( !queue.isEmpty() )
        {
            int cur = queue.dequeue();
            result += String.valueOf( cur );
            if ( !g.adjacencyList[ cur ].isEmpty() )
            {
                DoublyLinkedList.Node node = g.adjacencyList[ cur ].headNode;
                while ( node != null )
                {
                    if ( !visited[ ( int ) node.data ] )
                    {
                        result += node.data;
                    }
                    node = node.nextNode;
                }
            }
            visited[ cur ] = true;
        }
        return result;
    }
}

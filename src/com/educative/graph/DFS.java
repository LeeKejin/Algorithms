package com.educative.graph;

public class DFS
{
    public String dfs( Graph g )
    {
        String result = "";
        if ( g.vertices <= 0 ) return result;
        boolean[] visited = new boolean[ g.vertices ];
        for ( int i = 0; i < g.vertices; i++ )
        {
            if ( !visited[ i ] )
            {
                result += dfsVisited( g, i, visited );
            }

        }
        return result;
    }

    private String dfsVisited( Graph g, int source, boolean[] visited )
    {
        Stack< Integer > stack = new Stack<>( g.vertices );
        String res = "";
        stack.push( source );
        while ( !stack.isEmpty() )
        {
            int cur = stack.pop();
            res += cur;
            if ( !g.adjacencyList[ cur ].isEmpty() )
            {
                DoublyLinkedList.Node node = g.adjacencyList[ cur ].headNode;
                while ( node != null )
                {
                    if ( !visited[ ( int ) node.data ] )
                    {
                        stack.push( ( int ) node.data );

                    }
                    node = node.nextNode;
                }
            }
            visited[ cur ] = true;
        }
        return res;
    }

    public static void main( String[] args )
    {
        DFS test = new DFS();
        Graph g = new Graph( 5 );
        g.addEdge( 0, 1 );
        g.addEdge( 0, 2 );
        g.addEdge( 1, 3 );
        g.addEdge( 1, 4 );
        System.out.println( "Graph1:" );
        g.printGraph();
        System.out.println( "DFS traversal of Graph1 : " + test.dfs( g ) );
        System.out.println();

    }
}

package com.educative.graph;

public class NumberOfNodesInGivenLevel
{
    public int numberOfNodesInGivenLevel( Graph g, int source, int level )
    {
        int count = 0;
        int[] visited = new int[ g.vertices ];
        visited[ source ] = 1;
        bfs( g, source, level, visited );
        for ( int i = 0; i < g.vertices; i++ )
        {
            if ( visited[ i ] == level ) count++;
        }

        return count;
    }

    private void bfs( Graph g, int source, int level, int[] visited )
    {
        Queue< Integer > queue = new Queue<>( g.vertices );
        queue.enqueue( source );
        while ( !queue.isEmpty() )
        {
            int cur = queue.dequeue();

            if ( g.adjacencyList[ cur ] != null )
            {
                DoublyLinkedList.Node node = g.adjacencyList[ cur ].headNode;
                while ( node != null )
                {
                    if ( visited[ ( int ) node.data ] == 0 )
                    {
                        visited[ ( int ) node.data ] = visited[ cur ] + 1;
                    }
                    if ( visited[ ( int ) node.data ] < level )
                    {
                        queue.enqueue( ( int ) node.data );
                    }

                    node = node.nextNode;
                }
            }

        }
    }

    public static void main( String args[] )
    {
        Graph g = new Graph( 6 );
        g.addEdge( 0, 1 );
        g.addEdge( 0, 2 );
        g.addEdge( 1, 3 );
        g.addEdge( 2, 3 );
        g.addEdge( 3, 5 );
        g.addEdge( 2, 4 );

        int answer;
        NumberOfNodesInGivenLevel level = new NumberOfNodesInGivenLevel();
        answer = level.numberOfNodesInGivenLevel( g, 0, 1 );
        System.out.println( answer );
        answer = level.numberOfNodesInGivenLevel( g, 0, 2 );
        System.out.println( answer );
        answer = level.numberOfNodesInGivenLevel( g, 0, 3 );
        System.out.println( answer );
        answer = level.numberOfNodesInGivenLevel( g, 0, 4 );
        System.out.println( answer );
    }
}

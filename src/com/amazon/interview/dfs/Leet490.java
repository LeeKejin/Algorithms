package com.amazon.interview.dfs;

public class Leet490
{
    public boolean hasPath( int[][] maze, int[] start, int[] destination )
    {
        int m = maze.length;
        int n = maze[ 0 ].length;
        boolean[][] visited = new boolean[ m ][ n ];

        return dfs( start[ 0 ], start[ 1 ], visited, maze, destination );
    }

    private boolean dfs( int i, int j, boolean[][] visited, int[][] maze, int[] destination )
    {
        if ( visited[ i ][ j ] ) return false;
        visited[ i ][ j ] = true;
        if ( i == destination[ 0 ] && j == destination[ 1 ] ) return true;
        int up = i + 1;
        int down = i - 1;
        int right = j + 1;
        int left = j - 1;
        while ( up < maze.length && maze[ up ][ j ] != 1 )
        {
            up++;
        }

        if ( dfs( up - 1, j, visited, maze, destination ) ) return true;

        while ( down >= 0 && maze[ down ][ j ] != 1 )
        {
            down--;
        }

        if ( dfs( down + 1, j, visited, maze, destination ) ) return true;

        while ( right < maze[ 0 ].length && maze[ i ][ right ] != 1 )
        {

            right++;

        }
        if ( dfs( i, right - 1, visited, maze, destination ) ) return true;
        while ( left >= 0 && maze[ i ][ left ] != 1 )
        {

            left--;
        }
        if ( dfs( i, left + 1, visited, maze, destination ) ) return true;

        return false;
    }

}

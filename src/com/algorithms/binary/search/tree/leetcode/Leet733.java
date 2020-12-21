package com.algorithms.binary.search.tree.leetcode;

public class Leet733
{
    public int[][] floodFill( int[][] image, int sr, int sc, int newColor )
    {
        int origin = image[ sr ][ sc ];
        if ( newColor == origin ) return image;
        dfs( image, sr, sc, newColor, origin );
        return image;
    }

    private void dfs( int[][] image, int sr, int sc, int newColor, int origin )
    {
        if ( sr < 0 || sr >= image.length || sc < 0 || sc >= image[ 0 ].length || image[ sr ][ sc ] != origin ) return;
        image[ sr ][ sc ] = newColor;
        dfs( image, sr - 1, sc, newColor, origin );
        dfs( image, sr + 1, sc, newColor, origin );
        dfs( image, sr, sc - 1, newColor, origin );
        dfs( image, sr, sc + 1, newColor, origin );
    }
}

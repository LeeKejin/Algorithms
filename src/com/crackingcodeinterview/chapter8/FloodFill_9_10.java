package com.crackingcodeinterview.chapter8;

public class FloodFill_9_10 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        fill(image, sr, sc, newColor, oldColor, new boolean[image.length][image[0].length]);

        return image;
    }

    private void fill(int[][] image, int sr, int sc, int newColor, int oldColor, boolean[][] visited) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor || visited[sr][sc])
            return;
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        fill(image, sr + 1, sc, newColor, oldColor, visited);
        fill(image, sr - 1, sc, newColor, oldColor, visited);
        fill(image, sr, sc + 1, newColor, oldColor, visited);
        fill(image, sr, sc - 1, newColor, oldColor, visited);
    }
}

package com.google.dp.jumpgame;

/**
 * O(N)
 */
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int index, boolean[] visited) {
        if (index < 0 || index >= arr.length || visited[index]) return false;
        if (arr[index] == 0) return true;
        visited[index] = true;
        return dfs(arr, index + arr[index], visited) || dfs(arr, index - arr[index], visited);
    }


   /* public boolean canReach(int[] arr, int start) {
        boolean visited[] = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int start, boolean[] visited) {
        if (arr[start] == 0) return true;
        if (visited[start]) return false;
        visited[start] = true;

        if (start + arr[start] < arr.length) {
            if (dfs(arr, start + arr[start], visited)) return true;
        }
        if (start - arr[start] >= 0) {
            if (dfs(arr, start - arr[start], visited)) return true;
        }
        return false;
    }*/
}

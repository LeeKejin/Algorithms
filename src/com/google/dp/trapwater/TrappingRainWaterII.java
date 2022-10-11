package com.google.dp.trapwater;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 1) return 0;
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean vis[][] = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.add(new int[]{i, j, heightMap[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            for (int[] dir : dirs) {

                int nx = poll[0] + dir[0];
                int ny = poll[1] + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    if (poll[2] > heightMap[nx][ny]) {
                        res += (poll[2] - heightMap[nx][ny]);
                    }
                    int h = Math.max(heightMap[nx][ny], poll[2]);
                    vis[nx][ny] = true;
                    pq.add(new int[]{nx, ny, h});
                }
            }
        }
        return res;
    }
}
// //在做现在这份工作之前 前面所有工作里利润最大的
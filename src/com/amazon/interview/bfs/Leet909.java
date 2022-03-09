package com.amazon.interview.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
127. 单词接龙	LeetCode 题解链接	困难	🤩🤩🤩🤩🤩
403. 青蛙过河	LeetCode 题解链接	困难	🤩🤩🤩🤩🤩
752. 打开转盘锁	LeetCode 题解链接	中等	🤩🤩🤩🤩
773. 滑动谜题	LeetCode 题解链接	困难	🤩🤩🤩🤩
815. 公交路线	LeetCode 题解链接	困难	🤩🤩🤩🤩
847. 访问所有节点的最短路径	LeetCode 题解链接	困难	🤩🤩🤩🤩🤩
863. 二叉树中所有距离为 K 的结点	LeetCode 题解链接	中等	🤩🤩🤩🤩
909. 蛇梯棋	LeetCode 题解链接	中等	🤩🤩🤩🤩
1162. 地图分析	LeetCode 题解链接	中等	🤩🤩🤩🤩
2059. 转化数字的最小运算数	LeetCode 题解链接	中等	🤩🤩🤩🤩🤩
LCP 07. 传递信息	LeetCode 题解链接	简单

 */
public class Leet909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = p[0] + i;
                if (next > n * n) break;

                int[] location = getLocation(next, n);

                if (board[location[0]][location[1]] > 0) {
                    next = board[location[0]][location[1]];
                }
                if (next == n * n) return p[1] + 1;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, p[1] + 1});
                }
            }
        }
        return -1;
    }

    private int[] getLocation(int next, int n) {
        int r = (next - 1) / n;
        int c = (next - 1) % n;
        if (r % 2 == 1) {
            c = n - c - 1;
        }
        r = n - r - 1;
        return new int[]{r, c};
    }
}

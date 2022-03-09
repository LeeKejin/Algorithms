package com.google.tree.dfs;

public class Leet351_UnlockAndroid {
    int[][] jump = new int[10][10];
    boolean[] visited = new boolean[10];

    public int numberOfPatterns(int m, int n) {
        jump[1][3] = 2;
        jump[3][1] = 2;
        jump[1][9] = 5;
        jump[9][1] = 5;
        jump[1][7] = 4;
        jump[7][1] = 4;
        jump[2][8] = 5;
        jump[8][2] = 5;
        jump[3][7] = 5;
        jump[7][3] = 5;
        jump[9][3] = 6;
        jump[3][9] = 6;
        jump[4][6] = 5;
        jump[6][4] = 5;
        jump[7][9] = 8;
        jump[9][7] = 8;
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(1, i) * 4; //1,3,7,9 are same, when this dfs finish, it only allow case like 123
            res += dfs(2, i) * 4;//2,4,6,8 are same when 2 is visited, 1,3 can be connected, this also applied to 5. when this dfs finish, ot allow case
            // like 213, because 2 is selected at the beginning
            res += dfs(5, i);
        }
        return res;
    }

    private int dfs(int start, int remain) {
        if (remain == 1) return 1;
        visited[start] = true;
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (visited[jump[start][i]] || jump[start][i] == 0)) {
                count += dfs(i, remain - 1);
            }
        }
        visited[start] = false;
        return count;
    }

}

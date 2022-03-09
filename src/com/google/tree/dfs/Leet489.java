package com.google.tree.dfs;

import com.sun.tools.javac.util.Pair;

import java.util.HashSet;
import java.util.Set;

/*
Time complexity : \mathcal{O}(N - M)O(N−M), where NN is a number of cells in the room and MM is a number of obstacles.
 */
public class Leet489 {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0);
    }

    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair> set = new HashSet<>();

    private void dfs(Robot robot, int i, int j, int dir) {

        set.add(new Pair(i, j));
        robot.clean();
        for (int k = 0; k < 4; k++) {
            //keep move on the old dir
            int x = i + dirs[dir][0];
            int y = j + dirs[dir][1];

            if (!set.contains(new Pair(x, y)) && robot.move()) {
                dfs(robot, x, y, dir);
                goBack(i, j, dir, robot);//go back every step!!!!
            }
            robot.turnRight();
            dir++;// switch dir means dir needs to +1
            //0->up  1->right 2>down 3->left  if dir ==3, next dir would be up, so it needs to be changed to 4 manually
            if (dir == 4) dir = 0;
        }
    }

    private void goBack(int i, int j, int dir, Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

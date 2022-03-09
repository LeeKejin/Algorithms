package com.google.wried;

public class RemoveAllOnes {
    public boolean removeOnes(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            if (!isComplement(grid, i)) {
                if (!isIdentical(grid, i)) return false;
            }
        }
        return true;
    }

    public boolean isComplement(int[][] grid, int currIndex) {
        for (int i = 0; i < grid[0].length; i++) {
            if ((grid[0][i] == 0 && grid[currIndex][i] == 1) || (grid[0][i] == 1 && grid[currIndex][i] == 0)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isIdentical(int[][] grid, int currIndex) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == grid[currIndex][i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

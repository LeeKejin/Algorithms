package com.algorithms.tree.backtrace.twodimension;

import java.util.ArrayList;
import java.util.List;

public class Leet51 {
    static List<List<String>> results = new ArrayList<>();
    static boolean[] dia1;
    static boolean[] dia2;
    static boolean[] vertical;
    static List<Integer> column = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        if (n <= 0) return new ArrayList<>();
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        vertical = new boolean[n];
        putQueen(n, 0);
        return results;
    }

    private static void putQueen(int n, int index) {
        if (index == n) {
            System.out.print(column);
            generateBoard(column, n);
            return;
        }
        for (int i = 0; i < n; i++)//column
        {
            if (!dia1[index + i] && !dia2[index - i + n - 1] && !vertical[i]) {
                column.add(i);
                dia1[index + i] = true; //topRight->bottomLeft (3.0)->(2,1)->(1,2)->(0.3)
                dia2[index - i + n - 1] = true;//topLeft->bottomRight (0,0)->(1,1)
                vertical[i] = true;//the column has been applied

                putQueen(n, index + 1);

                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                vertical[i] = false;
                column.remove(column.size() - 1);
            }
        }

    }

    private static void generateBoard(List<Integer> column, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            int pos = column.get(i);
            for (int j = 0; j < n; j++) {
                if (j == pos) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        results.add(list);
    }

    static int[] array;

    public static List<List<String>> solveNQueensSolution1(int n) {

        if (n <= 0) return new ArrayList<>();
        array = new int[n];
        check(n, 0);
        return results;
    }

    private static void print() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder();

            int pos = array[i];
            for (int j = 0; j < array.length; j++) {
                if (j == pos) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        results.add(list);

    }

    private static void check(int n, int index) {
        if (index == n) {
            print();
            return;
        }
        for (int i = 0; i < n; i++) {
            array[index] = i;
            if (!noConflict(index)) {
                check(n, index + 1);
            }
        }
    }

    private static boolean noConflict(int index) {
        for (int i = 0; i < index; i++) {
            if (array[index] == array[i]
                    || Math.abs(index - i) == Math.abs(array[index] - array[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveNQueensSolution1(4);
        //        System.out.print( column );
        System.out.print(results);
    }
}

package com.google.tree.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point24 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (double num : nums) {
            list.add(num);
        }

        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) <= 0.01;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                double a = list.get(i);
                double b = list.get(j);

                List<Double> vals = Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
                List<Double> copy = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        copy.add(list.get(k));
                    }
                }
                for (double val : vals) {
                    copy.add(val);
                    if (dfs(copy)) return true;
                    copy.remove(copy.size() - 1);
                }
            }
        }
        return false;
    }
}


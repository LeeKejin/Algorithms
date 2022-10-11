package com.google.tree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tran : transactions) {
            map.put(tran[0], map.getOrDefault(tran[0], 0) - tran[2]);
            map.put(tran[1], map.getOrDefault(tran[1], 0) + tran[2]);
        }
        return settle(0, new ArrayList<>(map.values()));
    }

    private int settle(int start, List<Integer> debts) {
        while (start < debts.size() && debts.get(start) == 0) {
            start++;
        }
        if (start == debts.size()) return 0;
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debts.size(); i++) {
            if (debts.get(i) * debts.get(start) < 0) {  //一个正债 一个负债  所以相加看能不能平债，然后记录最小转账次数
                debts.set(i, debts.get(i) + debts.get(start));
                r = Math.min(r, 1 + settle(start + 1, debts));
                debts.set(i, debts.get(i) - debts.get(start));
            }
        }
        return r;
    }
}

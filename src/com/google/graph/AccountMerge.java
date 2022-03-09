package com.google.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountMerge {
    class UnionClass {
        int[] parents;

        public UnionClass(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parents[rootX] = rootY;
            }
        }

        private int find(int x) {
            if (x != parents[x]) return find(parents[x]);
            return parents[x];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> map = new HashMap<>();
        Map<Integer, String> indexMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            indexMap.put(i, name);
            for (int j = 1; j < account.size(); j++) {
                map.putIfAbsent(account.get(j), new ArrayList<>());
                map.get(account.get(j)).add(i);
            }
        }
        UnionClass unionClass = new UnionClass(accounts.size());
        for (String email : map.keySet()) {
            List<Integer> userIds = map.get(email);
            int id = userIds.get(0);
            for (int i = 1; i < userIds.size(); i++) {
                unionClass.merge(id, userIds.get(i));
            }
        }

        Map<Integer, Set<String>> emailMap = new HashMap<>();
        for (int id : indexMap.keySet()) {
            int parent = unionClass.find(id);
            emailMap.putIfAbsent(parent, new HashSet<>());
            for (int i = 1; i < accounts.get(parent).size(); i++) {
                emailMap.get(parent).add(accounts.get(parent).get(i));
            }
            for (int i = 1; i < accounts.get(id).size(); i++) {
                emailMap.get(parent).add(accounts.get(id).get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int id : emailMap.keySet()) {
            List<String> list = new ArrayList<>();
            list.addAll(emailMap.get(id));
            Collections.sort(list);
            list.add(0, indexMap.get(id));
            res.add(list);
        }
        return res;
    }
}

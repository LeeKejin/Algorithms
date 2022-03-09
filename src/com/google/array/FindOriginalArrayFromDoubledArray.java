package com.google.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[]{};
        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < changed.length; i++) {
            if (changed[i] == 0) {
                map.put(changed[i], map.get(changed[i]) - 2);
                if (map.get(changed[i]) >= 0) {
                    res.add(changed[i]);
                }
            } else if (map.containsKey(changed[i]) && map.get(changed[i]) > 0
                    && map.containsKey(changed[i] * 2) && map.get(changed[i] * 2) > 0) {
                map.put(changed[i], map.get(changed[i]) - 1);
                map.put(changed[i] * 2, map.get(changed[i] * 2) - 1);
                res.add(changed[i]);
            }
        }
        int size = changed.length / 2;
        if (size != res.size()) return new int[]{};
        int[] resArr = new int[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public int[] findOriginalArrayNoSort(int[] changed) {
        if (changed.length == 0 || changed.length % 2 != 0) return new int[]{};
        int freq[] = new int[100001];
        for (int change : changed) {
            freq[change]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0 && i * 2 < 100001 && freq[i * 2] > 0) {
                freq[i]--;
                freq[i * 2]--;
                list.add(i);
            }
        }
        if (list.size() != changed.length / 2) return new int[]{};
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) return new int[]{};
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] findOriginalArrayWithoutHashMap(int[] changed) {
        if (changed.length == 0 || changed.length % 2 != 0) return new int[]{};
        int freq[] = new int[100001];
        for (int change : changed) {
            freq[change]++;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(changed);
        for (int i = 0; i < changed.length; i++) {
            if (freq[changed[i]] > 0 && changed[i] * 2 < 100001 && freq[changed[i] * 2] > 0) {
                freq[changed[i]]--;
                freq[changed[i] * 2]--;
                list.add(changed[i]);
            }
        }
        if (list.size() != changed.length / 2) return new int[]{};
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) return new int[]{};
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

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

    /**
     * Faster Nasty
     */
    public int[] findOriginalArrayFaster(int[] changed) {
        if (changed.length % 2 != 0) return new int[]{};
        int max = Arrays.stream(changed).max().getAsInt();
        int visited[] = new int[max + 1];
        for (int i = 0; i < changed.length; i++) {
            visited[changed[i]]++;
        }
        List<Integer> set = new ArrayList<>();
        if (visited[0] != 0 && visited[0] < 2) return new int[]{};//for edge cases [1,2,1,0]
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] > 0 && (i * 2 > max || visited[i * 2] <= 0)) return new int[]{};
            while (visited[i] > 0 && i * 2 <= max && visited[i * 2] > 0) {
                set.add(i);
                visited[i]--;
                visited[i * 2]--;
            }

        }
        if (set.size() < changed.length / 2) return new int[]{};
        int[] res = new int[set.size()];
        int j = 0;
        for (int val : set) {
            res[j] = val;
            j++;
        }
        return res;
    }
}

package com.google.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArrayWithHashMap {
    Map<Integer, Integer>[] arrMap;
    int length;
    int snapId = 0;

    public SnapshotArrayWithHashMap(int length) {
        this.length = length;
        arrMap = new HashMap[length];
        for (int i = 0; i < length; i++) {
            arrMap[i] = new LinkedHashMap<>();
        }
    }

    public void set(int index, int val) {
        arrMap[index].put(snapId, val);
    }

    public int snap() {
        snapId++;
        return snapId - 1;
    }

    //left neigh
    public int get(int index, int snap_id) {
        Map<Integer, Integer> map = arrMap[index];
        if (map.containsKey(snap_id)) return map.get(snap_id);
        List<Integer> list = new ArrayList<>(map.keySet());
        list.stream().sorted();
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == snap_id) break;
            if (list.get(mid) < snap_id) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (r == -1) return 0;
        return map.get(list.get(r));
    }


}

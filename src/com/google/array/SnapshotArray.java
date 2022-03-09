package com.google.array;

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {
    Map<Integer, Map<Integer, Integer>> mapWithSnap = new HashMap<>();
    int snapId = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public SnapshotArray(int length) {
        mapWithSnap.put(0, new HashMap<>());
    }

    public void set(int index, int val) {
        map.put(index, val);
    }

    public int snap() {
        Map<Integer, Integer> oldMap = new HashMap<>();
        map.keySet().stream().forEach(k -> oldMap.put(k, map.get(k)));
        mapWithSnap.put(snapId, oldMap);
        snapId++;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        if (mapWithSnap.get(snap_id) != null && mapWithSnap.get(snap_id).get(index) != null) {
            return mapWithSnap.get(snap_id).get(index);
        }
        return 0;
    }
}

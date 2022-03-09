package com.google.binary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leet981
public class TimeBasedKeyValueStore {
    public TimeBasedKeyValueStore() {

    }

    class State {
        String value;
        int version;

        public State(String value, int version) {
            this.value = value;
            this.version = version;
        }
    }

    Map<String, List<State>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new State(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<State> list = map.get(key);
        int index = find(list, timestamp);
        if (index == -1) return "";
        return list.get(index).value;
    }

    private int find(List<State> list, int timestamp) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).version == timestamp) return mid;
            else if (list.get(mid).version < timestamp) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}

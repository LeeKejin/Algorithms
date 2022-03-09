package com.google.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    public RandomizedSet() {
    }

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int i = map.get(val);
        int last = list.get(list.size() - 1);
        map.put(last, i);
        list.set(i, last);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {

        int n = random.nextInt(list.size());
        return list.get(n);
    }
}

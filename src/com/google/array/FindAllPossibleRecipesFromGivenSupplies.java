package com.google.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, List<String>> map = new HashMap<>();
        Set<String> supplySet = new HashSet<>();
        supplySet.addAll(Arrays.asList(supplies));

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            index.put(recipes[i], i);
        }
        int[] degrees = new int[recipes.length];
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ingred : ingredients.get(i)) {
                if (supplySet.contains(ingred)) continue;
                map.putIfAbsent(ingred, new ArrayList<>());
                map.get(ingred).add(recipes[i]);
                degrees[i]++;
            }

        }
        for (int i = 0; i < recipes.length; i++) {
            if (degrees[i] == 0) {
                queue.add(recipes[i]);
            }
        }
        while (!queue.isEmpty()) {
            String food = queue.poll();
            res.add(food);
            if (!map.containsKey(food)) continue;
            for (String next : map.get(food)) {
                degrees[index.get(next)]--;
                if (degrees[index.get(next)] == 0) {
                    queue.add(next);
                }
            }
        }
        return res;
    }
}

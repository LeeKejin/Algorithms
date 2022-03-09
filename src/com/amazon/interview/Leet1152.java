package com.amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
Time must be taken into account! The values in timestamp could be out of order like below
new String[]{"dowg", "dowg", "dowg"}, new int[]{158931262, 562600350, 148438945}, new String[]{"y",
                "loedo", "y"})

                the correct output should be "y", "y", "loedo"
                NOT "y", "loedo", "y"
 */
public class Leet1152 {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, Map<Integer, String>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new TreeMap<>());//Treemap helps to sort time
            map.get(username[i]).put(timestamp[i], website[i]);
        }

        List<String> combinations = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name).size() < 3) continue;
            combinations.addAll(generateCombinations(map.get(name)));
        }

        Map<Integer, String> seqMap = new HashMap<>();
        Map<String, Integer> freqMap = new HashMap<>();
        int count = 0;
        for (String combination : combinations) {
            freqMap.put(combination, freqMap.getOrDefault(combination, 0) + 1);
            int freq = freqMap.get(combination);
            if (freq >= count) {  //---> IMPORTANT, DON'T do Math.max(count, freq)!
                if (seqMap.containsKey(freq)) {
                    if (seqMap.get(count).compareTo(combination) > 0) {
                        seqMap.put(count, combination);
                    }
                } else {
                    seqMap.put(freq, combination);
                }
                count = freq;
            }

        }
        String str = seqMap.get(count);
        return Arrays.asList(str.split(","));
    }

    private Set<String> generateCombinations(Map<Integer, String> timeWebMap) {
        int size = timeWebMap.size();
        List<String> webs = new ArrayList<>();
        Set<String> combinations = new HashSet<>();
        webs.addAll(timeWebMap.values());
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    String str = webs.get(i) + "," + webs.get(j) + "," + webs.get(k);
                    combinations.add(str);
                }
            }
        }
        return combinations;
    }

    public static void main(String[] args) {
        Leet1152 test = new Leet1152();
        System.out.println(test.mostVisitedPattern(new String[]{"dowg", "dowg", "dowg"}, new int[]{158931262, 562600350, 148438945}, new String[]{"y",
                "loedo", "y"}));
    }
}

package com.amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new TreeMap<>());
            map.get(username[i]).put(timestamp[i], website[i]);
        }
        List<String> webList = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name).size() < 3) continue;
            if (map.get(name).size() == 3) {
                Map<Integer, String> timeMap = map.get(name);
                StringBuilder sb = new StringBuilder();
                for (int key : timeMap.keySet()) {
                    sb.append(timeMap.get(key) + "-");
                }

                webList.add(sb.toString());
            }

            webList.addAll(generateCombo(map.get(name)));
        }
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String web : webList) {
            freqMap.put(web, freqMap.getOrDefault(web, 0) + 1);
        }

        int freq = 0;
        String res = "";
        for (String webs : freqMap.keySet()) {
            if (freqMap.get(webs) >= freq) {
                if ((freqMap.get(webs) == freq && webs.compareTo(res) < 0) || freqMap.get(webs) > freq) {
                    freq = freqMap.get(webs);
                    res = webs;
                }

            }
        }
        String[] strs = res.split("-");
        List<String> list = new ArrayList<>();
        list.add(strs[0]);
        list.add(strs[1]);
        list.add(strs[2]);
        return list;
    }

    private Set<String> generateCombo(Map<Integer, String> timeWebMap) {
        int size = timeWebMap.size();
        List<String> webs = new ArrayList<>();
        Set<String> combinations = new HashSet<>();
        webs.addAll(timeWebMap.values());
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    String str = webs.get(i) + "-" + webs.get(j) + "-" + webs.get(k);
                    combinations.add(str);
                }
            }
        }
        return combinations;
    }
/*
 private Set<String> generateCombo(TreeMap<Integer, String> webs) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        list.addAll(webs.values());
        generate(list, 0, set, new ArrayList<>());
        return set;
    }

    private void generate(List<String> webs, int start, Set<String> set, List<String> list) {

        if (list.size() == 3) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(list.get(i) + "-");
            }
            set.add(sb.toString());
            return;
        }
        for (int i = start; i < webs.size(); i++) {
            list.add(webs.get(i));
            generate(webs, i + 1, set, list);
            list.remove(list.size() - 1);
        }

    }
 */

    public static void main(String[] args) {
        Leet1152 test = new Leet1152();

        System.out.println(test.mostVisitedPattern(new String[]{"dowg", "dowg", "dowg"}, new int[]{158931262, 562600350, 148438945}, new String[]{"y",
                "loedo", "y"}));
    }
}

package com.algorithms.array.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * For a list of votes, return an ordered set of candidate in descending order of their votes.
 */
public class Leet1366 {
    class Node {
        char name;
        int[] freq;

        Node(char name, int[] freq) {
            this.name = name;
            this.freq = freq;
        }
    }

    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < votes[0].length(); i++) {
            map.put(votes[0].charAt(i), new int[votes[0].length()]);
        }

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                map.get(vote.charAt(i))[i]++;
            }
        }

        Node[] temp = new Node[map.size()];
        int j = 0;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            temp[j] = new Node(entry.getKey(), entry.getValue());
            j++;
        }
        Arrays.sort(temp, (t1, t2) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if (t1.freq[i] != t2.freq[i]) {
                    return t2.freq[i] - t1.freq[i];
                }
            }
            return t1.name - t2.name;
        });
        String str = "";
        for (Node node : temp) {
            str += String.valueOf(node.name);
        }
        return str;
    }
}

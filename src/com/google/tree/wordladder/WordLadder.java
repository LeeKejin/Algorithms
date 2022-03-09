package com.google.tree.wordladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    /*
    O(pow(N,26)) N is words num
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        if (!wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                char[] chs = word.toCharArray();

                for (int j = 0; j < word.length(); j++) {
                    char ch = chs[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) continue;
                        chs[j] = c;
                        String t = String.valueOf(chs);
                        if (t.equals(endWord)) return step + 1;
                        if (!set.contains(t)) continue;
                        queue.add(t);
                        set.remove(t);
                    }
                    chs[j] = ch;
                }
            }
        }
        return 0;
    }
    /*
    Time Complexity: O({M}^2 \times N)O(M
2
 ×N), where MM is the length of each word and NN is the total number of words in the input word list.

For each word in the word list, we iterate over its length to find all the intermediate words corresponding to it. Since the length of each word is MM and we have NN words, the total number of iterations the algorithm takes to create all_combo_dict is M \times NM×N. Additionally, forming each of the intermediate word takes O(M)O(M) time because of the substring operation used to create the new string. This adds up to a complexity of O({M}^2 \times N)O(M
2
 ×N).

Breadth first search in the worst case might go to each of the NN words. For each word, we need to examine M possible intermediate words/combinations.
Notice, we have used the substring operation to find each of the combination. Thus, M combinations take O({M} ^ 2)O(M
2
 ) time. As a result, the time complexity of BFS traversal would also be O({M}^2 \times N)O(M
2
 ×N).

Combining the above steps, the overall time complexity of this approach is O({M}^2 \times N)O(M
2
 ×N).

Space Complexity: O(M^2 * N)
     */

    public int ladderLengthWithMap(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        if (!wordList.contains(endWord)) return 0;

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < beginWord.length(); i++) {
            for (String word : wordList) {
                char[] chs = word.toCharArray();
                chs[i] = '*';
                String s = String.valueOf(chs);
                map.putIfAbsent(s, new ArrayList<>());
                map.get(s).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                char[] chs = word.toCharArray();

                for (int j = 0; j < word.length(); j++) {
                    char ch = chs[j];
                    chs[j] = '*';
                    for (String w : map.getOrDefault(String.valueOf(chs), new ArrayList<>())) {
                        if (w.equals(endWord)) return step + 1;
                        if (!set.contains(w)) continue;
                        queue.add(w);
                        set.remove(w);
                    }
                    chs[j] = ch;
                }
            }
        }
        return 0;
    }

    public int ladderLengthBiDir(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);

        if (!dict.contains(endWord)) return 0;

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < beginWord.length(); i++) {
            for (String word : wordList) {
                char[] chs = word.toCharArray();
                chs[i] = '*';
                String s = String.valueOf(chs);
                map.putIfAbsent(s, new ArrayList<>());
                map.get(s).add(word);
            }
        }

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        int step = 0;
        while (!q1.isEmpty() && q2.isEmpty()) {
            step++;
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> q = new HashSet<>();
            for (String word : q1) {
                for (int i = 0; i < word.length(); i++) {
                    char chs[] = word.toCharArray();
                    char ch = chs[i];
                    chs[i] = '*';
                    String t = String.valueOf(chs);
                    for (String w : map.getOrDefault(t, new ArrayList<>())) {
                        if (q2.contains(w)) return step + 1;
                        if (!dict.contains(w)) continue;
                        dict.remove(w);
                        q.add(w);
                    }
                    chs[i] = ch;
                }

            }
            q1 = q;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        test.ladderLengthWithMap("hit",
                "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

    }
}

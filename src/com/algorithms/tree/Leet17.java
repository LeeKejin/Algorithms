package com.algorithms.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet17 {
    static List<String> results = new ArrayList<>();
    static List<String> list = new ArrayList<>();

    static {
        list.add("");
        list.add("");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        composeResults(digits, 0, "");
        return results;
    }

    private static void composeResults(String digits, int index, String word) {

        if (digits == null || digits.equals("")) return;
        if (index == digits.length()) {
            results.add(word);
            return;
        }
        String letters = list.get(digits.charAt(index) - '0');
        for (int i = 0; i < letters.length(); i++) {
            composeResults(digits, index + 1, word + letters.charAt(i));
        }
    }

    public List<String> letterCombinationsDFS(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        List<String> res = dfs(map, 0, digits);
        return res;
    }

    private List<String> dfs(Map<Integer, List<Character>> map, int i, String digits) {
        if (i == digits.length()) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        int num = Integer.parseInt(String.valueOf(digits.charAt(i)));
        List<String> subList = dfs(map, i + 1, digits);

        for (char ch : map.get(num)) {
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            for (String str : subList) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(sb);
                stringBuilder.append(str);

                list.add(stringBuilder.toString());
            }
            if (subList.isEmpty()) {
                list.add(sb.toString());
            }

        }

        return list;
    }
}





















/*
if ( index == digits.length() )
        {
            results.add( word );
            return;
        }
        if ( digits.charAt( index ) == '0' || digits.charAt( index ) == '1' ) return;

        String letters = list.get( digits.charAt( index ) - '0' );
        for ( int i = 0; i < letters.length(); i++ )
        {
            composeResults( digits, index + 1, word + letters.charAt( i ) );
        }
 */

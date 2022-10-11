package com.crackingcodeinterview.chapter8;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_8_9 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, n, new StringBuilder());
        return list;
    }

    private void generate(int left, int right, StringBuilder cur) {
        if (left == 0 && right == 0) {
            list.add(cur.toString());
            return;
        }
        if (left > 0) {
            generate(left - 1, right, cur.append("("));
            cur.deleteCharAt(cur.length() - 1);
        }
        if (left < right) {
            generate(left, right - 1, cur.append(")"));
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis_8_9 test = new GenerateParenthesis_8_9();
        test.generateParenthesis(3);
    }
}

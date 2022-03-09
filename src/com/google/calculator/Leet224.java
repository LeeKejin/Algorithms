package com.google.calculator;

import java.util.Stack;

public class Leet224 {
    /*
    Cal with + - () No * /
    * */
    public int calculate(String s) {
        if (s == null) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> mark = new Stack<>();
        int sign = 1;
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '(') {
                mark.push(sign);
                stack.push(res);
                res = 0;
                sign = 1;
                num = 0;
            } else if (ch == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (ch == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (ch == ')') {
                res += sign * num;
                int m = mark.pop();
                res *= m;
                int v = stack.pop();
                res += v;
                num = 0;
            }
        }
        res += sign * num;

        return res;
    }
}
